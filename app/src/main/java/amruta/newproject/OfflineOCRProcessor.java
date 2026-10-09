package amruta.newproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OfflineOCRProcessor
 * Completely on-device text recognition using Google ML Kit.
 * Does NOT call any cloud API or require internet connectivity.
 */
public class OfflineOCRProcessor {

    private static final String TAG = "OfflineOCRProcessor";

    public interface OCRCallback {
        void onSuccess(String extractedText);
        void onError(String errorMessage);
    }

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final TextRecognizer textRecognizer;

    public OfflineOCRProcessor() {
        // Standalone on-device Latin text recognizer
        this.textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
    }

    /**
     * Extracts text asynchronously from an image Uri.
     */
    public void processImageUri(@NonNull Context context, @NonNull Uri imageUri, @NonNull OCRCallback callback) {
        executor.execute(() -> {
            try {
                Bitmap bitmap = ImageProcessor.decodeForOCR(context, imageUri);
                if (bitmap == null) {
                    postError(callback, "Unable to load or decode image from device storage.");
                    return;
                }

                processBitmapInternal(bitmap, callback);

            } catch (Throwable t) {
                Log.e(TAG, "Error in processImageUri", t);
                postError(callback, "Failed to process image: " + t.getMessage());
            }
        });
    }

    /**
     * Extracts text asynchronously from an in-memory Bitmap.
     */
    public void processBitmap(@NonNull Bitmap bitmap, @NonNull OCRCallback callback) {
        executor.execute(() -> processBitmapInternal(bitmap, callback));
    }

    private void processBitmapInternal(@NonNull Bitmap bitmap, @NonNull OCRCallback callback) {
        try {
            InputImage inputImage = InputImage.fromBitmap(bitmap, 0);

            textRecognizer.process(inputImage)
                    .addOnSuccessListener(visionText -> {
                        String text = visionText.getText();
                        postSuccess(callback, text != null ? text.trim() : "");
                    })
                    .addOnFailureListener(e -> {
                        Log.e(TAG, "ML Kit OCR recognition failed", e);
                        postError(callback, "On-device OCR failed: " + e.getLocalizedMessage());
                    });

        } catch (Throwable t) {
            Log.e(TAG, "Exception during ML Kit recognition", t);
            postError(callback, "Recognition error: " + t.getMessage());
        }
    }

    private void postSuccess(OCRCallback callback, String text) {
        mainHandler.post(() -> callback.onSuccess(text));
    }

    private void postError(OCRCallback callback, String message) {
        mainHandler.post(() -> callback.onError(message));
    }

    public void close() {
        try {
            textRecognizer.close();
        } catch (Exception ignored) {
        }
    }
}
