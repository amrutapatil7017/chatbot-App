package amruta.newproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Log;

import java.io.InputStream;

/**
 * ImageProcessor
 * Handles safe image loading from Content Uris, memory-safe downsampling,
 * EXIF rotation correction, and thumbnail generation.
 */
public class ImageProcessor {

    private static final String TAG = "ImageProcessor";
    public static final int MAX_OCR_DIMENSION = 1600;
    public static final int MAX_THUMBNAIL_DIMENSION = 360;

    /**
     * Decodes and scales a Bitmap safely for offline OCR processing.
     */
    public static Bitmap decodeForOCR(Context context, Uri uri) {
        return decodeSampledBitmap(context, uri, MAX_OCR_DIMENSION, MAX_OCR_DIMENSION);
    }

    /**
     * Decodes a lightweight thumbnail for UI preview.
     */
    public static Bitmap decodeThumbnail(Context context, Uri uri) {
        return decodeSampledBitmap(context, uri, MAX_THUMBNAIL_DIMENSION, MAX_THUMBNAIL_DIMENSION);
    }

    /**
     * Decodes a thumbnail with a specific max dimension constraint.
     */
    public static Bitmap getThumbnail(Context context, Uri uri, int maxDim) {
        return decodeSampledBitmap(context, uri, maxDim, maxDim);
    }

    /**
     * Decodes a bitmap with inSampleSize to prevent OutOfMemoryError,
     * and corrects any EXIF rotation.
     */
    public static Bitmap decodeSampledBitmap(Context context, Uri uri, int reqWidth, int reqHeight) {
        if (context == null || uri == null) return null;

        try {
            // Step 1: Decode dimensions only
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;

            try (InputStream is = context.getContentResolver().openInputStream(uri)) {
                if (is == null) return null;
                BitmapFactory.decodeStream(is, null, options);
            }

            if (options.outWidth <= 0 || options.outHeight <= 0) {
                return null;
            }

            // Step 2: Compute inSampleSize
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;

            // Step 3: Decode full sampled bitmap
            Bitmap decodedBitmap;
            try (InputStream is = context.getContentResolver().openInputStream(uri)) {
                if (is == null) return null;
                decodedBitmap = BitmapFactory.decodeStream(is, null, options);
            }

            if (decodedBitmap == null) return null;

            // Step 4: Correct EXIF rotation if present
            int rotation = getExifOrientation(context, uri);
            if (rotation != 0) {
                decodedBitmap = rotateBitmap(decodedBitmap, rotation);
            }

            return decodedBitmap;

        } catch (Exception e) {
            Log.e(TAG, "Error decoding image uri: " + uri, e);
            return null;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return Math.max(1, inSampleSize);
    }

    private static int getExifOrientation(Context context, Uri uri) {
        try (InputStream is = context.getContentResolver().openInputStream(uri)) {
            if (is == null) return 0;
            ExifInterface exif = new ExifInterface(is);
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    return 90;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    return 180;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    return 270;
                default:
                    return 0;
            }
        } catch (Exception ignored) {
            return 0;
        }
    }

    private static Bitmap rotateBitmap(Bitmap source, int angle) {
        if (angle == 0 || source == null) return source;
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        Bitmap rotated = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
        if (rotated != source && !source.isRecycled()) {
            source.recycle();
        }
        return rotated;
    }
}
