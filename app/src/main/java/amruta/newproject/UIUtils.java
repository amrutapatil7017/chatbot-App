package amruta.newproject;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;

public class UIUtils {

    public static int dpToPx(Context context, float dp) {
        return Math.round(dp * context.getResources().getDisplayMetrics().density);
    }

    public static GradientDrawable createRoundedDrawable(int fillColor, float cornerRadiusDp, int strokeColor, float strokeWidthDp, Context context) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(fillColor);
        if (cornerRadiusDp > 0) {
            drawable.setCornerRadius(dpToPx(context, cornerRadiusDp));
        }
        if (strokeWidthDp > 0 && strokeColor != Color.TRANSPARENT) {
            drawable.setStroke(dpToPx(context, strokeWidthDp), strokeColor);
        }
        return drawable;
    }

    public static GradientDrawable createBubbleDrawable(int fillColor, float topLeftDp, float topRightDp, float bottomRightDp, float bottomLeftDp, Context context) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(fillColor);
        float tl = dpToPx(context, topLeftDp);
        float tr = dpToPx(context, topRightDp);
        float br = dpToPx(context, bottomRightDp);
        float bl = dpToPx(context, bottomLeftDp);
        drawable.setCornerRadii(new float[]{tl, tl, tr, tr, br, br, bl, bl});
        return drawable;
    }

    public static Drawable createButtonDrawable(int normalColor, int pressedColor, float cornerRadiusDp, Context context) {
        int radiusPx = dpToPx(context, cornerRadiusDp);
        GradientDrawable content = new GradientDrawable();
        content.setColor(normalColor);
        content.setCornerRadius(radiusPx);

        GradientDrawable mask = new GradientDrawable();
        mask.setColor(Color.WHITE);
        mask.setCornerRadius(radiusPx);

        return new RippleDrawable(ColorStateList.valueOf(pressedColor), content, mask);
    }

    public static Bitmap createSendIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);

        Path path = new Path();
        float margin = sizePx * 0.22f;
        float w = sizePx - 2 * margin;
        float h = sizePx - 2 * margin;

        path.moveTo(margin + w, margin + h * 0.5f);
        path.lineTo(margin, margin);
        path.lineTo(margin + w * 0.25f, margin + h * 0.5f);
        path.lineTo(margin, margin + h);
        path.close();

        canvas.drawPath(path, paint);
        return bitmap;
    }

    public static Bitmap createMenuIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 2.2f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float startX = sizePx * 0.22f;
        float endX = sizePx * 0.78f;
        float y1 = sizePx * 0.32f;
        float y2 = sizePx * 0.50f;
        float y3 = sizePx * 0.68f;

        canvas.drawLine(startX, y1, endX, y1, paint);
        canvas.drawLine(startX, y2, endX, y2, paint);
        canvas.drawLine(startX, y3, endX, y3, paint);

        return bitmap;
    }

    public static Bitmap createMicIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);

        float cx = sizePx / 2f;

        // 1. Microphone Capsule
        paint.setStyle(Paint.Style.FILL);
        float capWidth = sizePx * 0.32f;
        float capHeight = sizePx * 0.42f;
        float capLeft = cx - capWidth / 2f;
        float capTop = sizePx * 0.16f;
        RectF capRect = new RectF(capLeft, capTop, capLeft + capWidth, capTop + capHeight);
        float capRx = capWidth / 2f;
        canvas.drawRoundRect(capRect, capRx, capRx, paint);

        // 2. Microphone Arc / Cradle
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float arcWidth = sizePx * 0.52f;
        float arcHeight = sizePx * 0.48f;
        float arcLeft = cx - arcWidth / 2f;
        float arcTop = sizePx * 0.22f;
        RectF arcRect = new RectF(arcLeft, arcTop, arcLeft + arcWidth, arcTop + arcHeight);
        canvas.drawArc(arcRect, 0, 180, false, paint);

        // 3. Base Stem Line
        float stemTopY = arcTop + arcHeight;
        float stemBottomY = sizePx * 0.84f;
        canvas.drawLine(cx, stemTopY, cx, stemBottomY, paint);

        // 4. Base Foot Line
        float footHalfWidth = sizePx * 0.18f;
        canvas.drawLine(cx - footHalfWidth, stemBottomY, cx + footHalfWidth, stemBottomY, paint);

        return bitmap;
    }

    private static Bitmap sCachedBotAvatarRaw;

    public static Bitmap createBotAvatarBitmap(Context context, int sizeDp) {
        int sizePx = dpToPx(context, sizeDp);
        if (sizePx <= 0) sizePx = 1;

        if (sCachedBotAvatarRaw == null && context != null) {
            try {
                sCachedBotAvatarRaw = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_chai_icon);
            } catch (Exception ignored) {}
        }

        if (sCachedBotAvatarRaw != null) {
            return Bitmap.createScaledBitmap(sCachedBotAvatarRaw, sizePx, sizePx, true);
        }

        // Fallback if resource is unavailable
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#050811"));
        canvas.drawCircle(sizePx / 2f, sizePx / 2f, sizePx / 2f, paint);
        paint.setColor(Color.parseColor("#22D3EE"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.5f));
        canvas.drawCircle(sizePx / 2f, sizePx / 2f, sizePx * 0.46f, paint);
        return bitmap;
    }

    public static Bitmap createUserAvatarBitmap(Context context, int sizeDp) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Circular background
        paint.setColor(Color.parseColor("#DBEAFE")); // Soft blue fill
        canvas.drawCircle(sizePx / 2f, sizePx / 2f, sizePx / 2f, paint);

        // Head
        paint.setColor(Color.parseColor("#2563EB")); // Blue accent
        float cx = sizePx / 2f;
        float cy = sizePx * 0.38f;
        float headRadius = sizePx * 0.18f;
        canvas.drawCircle(cx, cy, headRadius, paint);

        // Body / Shoulders
        RectF bodyRect = new RectF(cx - sizePx * 0.32f, sizePx * 0.62f, cx + sizePx * 0.32f, sizePx * 1.05f);
        canvas.drawOval(bodyRect, paint);

        return bitmap;
    }

    public static Bitmap createGoogleGIconBitmap(Context context, int sizeDp) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        float cx = sizePx / 2f;
        float cy = sizePx / 2f;
        float radius = sizePx * 0.38f;
        float strokeWidth = sizePx * 0.18f;

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);

        RectF bounds = new RectF(cx - radius, cy - radius, cx + radius, cy + radius);

        // Red arc
        paint.setColor(Color.parseColor("#EA4335"));
        canvas.drawArc(bounds, 190, 120, false, paint);

        // Yellow arc
        paint.setColor(Color.parseColor("#FBBC05"));
        canvas.drawArc(bounds, 120, 75, false, paint);

        // Green arc
        paint.setColor(Color.parseColor("#34A853"));
        canvas.drawArc(bounds, 25, 95, false, paint);

        // Blue arc
        paint.setColor(Color.parseColor("#4285F4"));
        canvas.drawArc(bounds, -25, 50, false, paint);

        // Horizontal bar
        paint.setStyle(Paint.Style.FILL);
        float barWidth = radius * 0.85f;
        canvas.drawRect(cx - sizePx * 0.05f, cy - strokeWidth / 2f, cx + barWidth, cy + strokeWidth / 2f, paint);

        return bitmap;
    }

    public static Bitmap createEyeIconBitmap(Context context, int sizeDp, boolean isVisible, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float cx = sizePx / 2f;
        float cy = sizePx / 2f;
        float rx = sizePx * 0.40f;
        float ry = sizePx * 0.24f;

        // Eye shape
        Path eyePath = new Path();
        eyePath.moveTo(cx - rx, cy);
        eyePath.quadTo(cx, cy - ry * 2f, cx + rx, cy);
        eyePath.quadTo(cx, cy + ry * 2f, cx - rx, cy);
        canvas.drawPath(eyePath, paint);

        // Pupil
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, sizePx * 0.12f, paint);

        // Slash line if hidden
        if (!isVisible) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(dpToPx(context, 2.0f));
            canvas.drawLine(cx - rx * 0.8f, cy - ry * 1.5f, cx + rx * 0.8f, cy + ry * 1.5f, paint);
        }

        return bitmap;
    }

    public static Bitmap createAttachmentIconBitmap(Context context, int sizeDp, int color) {
        return createCameraIconBitmap(context, sizeDp, color);
    }

    public static Bitmap createPlusIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 2.4f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float cx = sizePx / 2f;
        float cy = sizePx / 2f;
        float len = sizePx * 0.28f;

        // Horizontal line
        canvas.drawLine(cx - len, cy, cx + len, cy, paint);
        // Vertical line
        canvas.drawLine(cx, cy - len, cx, cy + len, paint);

        return bitmap;
    }

    public static Bitmap createCameraIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 2.0f));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        // Clean Camera / Photo icon
        float pad = sizePx * 0.20f;
        float bodyTop = sizePx * 0.35f;
        float bodyBottom = sizePx - pad;
        float bodyLeft = pad;
        float bodyRight = sizePx - pad;

        // Camera body
        RectF bodyRect = new RectF(bodyLeft, bodyTop, bodyRight, bodyBottom);
        canvas.drawRoundRect(bodyRect, dpToPx(context, 4), dpToPx(context, 4), paint);

        // Flash / prism top bump
        float bumpLeft = sizePx * 0.38f;
        float bumpRight = sizePx * 0.62f;
        float bumpTop = sizePx * 0.24f;
        RectF bumpRect = new RectF(bumpLeft, bumpTop, bumpRight, bodyTop);
        canvas.drawRoundRect(bumpRect, dpToPx(context, 2), dpToPx(context, 2), paint);

        // Lens circle
        float cx = sizePx / 2f;
        float cy = (bodyTop + bodyBottom) / 2f;
        canvas.drawCircle(cx, cy, sizePx * 0.16f, paint);

        return bitmap;
    }

    public static Bitmap createGalleryIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 2.0f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float pad = sizePx * 0.18f;
        RectF frame = new RectF(pad, pad, sizePx - pad, sizePx - pad);
        canvas.drawRoundRect(frame, dpToPx(context, 4), dpToPx(context, 4), paint);

        // Mountain triangles
        Path path = new Path();
        float b = sizePx - pad;
        path.moveTo(pad + sizePx * 0.1f, b);
        path.lineTo(pad + sizePx * 0.30f, pad + sizePx * 0.35f);
        path.lineTo(pad + sizePx * 0.48f, b);
        canvas.drawPath(path, paint);

        // Sun dot
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(sizePx - pad - sizePx * 0.18f, pad + sizePx * 0.20f, sizePx * 0.08f, paint);

        return bitmap;
    }

    public static Bitmap createFilesIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        float left = sizePx * 0.24f;
        float right = sizePx * 0.76f;
        float top = sizePx * 0.18f;
        float bottom = sizePx * 0.82f;
        float fold = sizePx * 0.18f;

        // Document outline with folded top-right corner
        Path docPath = new Path();
        docPath.moveTo(left, top);
        docPath.lineTo(right - fold, top);
        docPath.lineTo(right, top + fold);
        docPath.lineTo(right, bottom);
        docPath.lineTo(left, bottom);
        docPath.close();
        canvas.drawPath(docPath, paint);

        // Fold corner flap
        Path foldPath = new Path();
        foldPath.moveTo(right - fold, top);
        foldPath.lineTo(right - fold, top + fold);
        foldPath.lineTo(right, top + fold);
        canvas.drawPath(foldPath, paint);

        // Lines inside document
        float lineLeft = left + sizePx * 0.12f;
        float lineRight = right - sizePx * 0.12f;
        float y1 = top + sizePx * 0.30f;
        float y2 = top + sizePx * 0.44f;
        float y3 = top + sizePx * 0.58f;

        canvas.drawLine(lineLeft, y1, lineRight, y1, paint);
        canvas.drawLine(lineLeft, y2, lineRight, y2, paint);
        canvas.drawLine(lineLeft, y3, lineLeft + (lineRight - lineLeft) * 0.55f, y3, paint);

        return bitmap;
    }

    public static Bitmap createPluginsIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        float pad = sizePx * 0.22f;
        float blockSize = sizePx * 0.23f;
        float gap = sizePx * 0.08f;
        float r = dpToPx(context, 2.5f);

        float x1 = pad;
        float x2 = pad + blockSize + gap;
        float y1 = pad;
        float y2 = pad + blockSize + gap;

        // Block 1 (top-left)
        canvas.drawRoundRect(new RectF(x1, y1, x1 + blockSize, y1 + blockSize), r, r, paint);
        // Block 2 (top-right)
        canvas.drawRoundRect(new RectF(x2, y1, x2 + blockSize, y1 + blockSize), r, r, paint);
        // Block 3 (bottom-left)
        canvas.drawRoundRect(new RectF(x1, y2, x1 + blockSize, y2 + blockSize), r, r, paint);

        // Block 4 (bottom-right filled)
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(x2, y2, x2 + blockSize, y2 + blockSize), r, r, paint);

        return bitmap;
    }

    public static Bitmap createThinkHarderIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        float cx = sizePx / 2f;
        float cy = sizePx * 0.44f;
        float radius = sizePx * 0.22f;

        // Lightbulb bulb arc
        RectF bulbBounds = new RectF(cx - radius, cy - radius, cx + radius, cy + radius);
        canvas.drawArc(bulbBounds, 140, 260, false, paint);

        // Bulb neck
        Path neckPath = new Path();
        neckPath.moveTo(cx - radius * 0.65f, cy + radius * 0.72f);
        neckPath.lineTo(cx - radius * 0.45f, cy + radius * 1.35f);
        neckPath.lineTo(cx + radius * 0.45f, cy + radius * 1.35f);
        neckPath.lineTo(cx + radius * 0.65f, cy + radius * 0.72f);
        canvas.drawPath(neckPath, paint);

        // Base screw lines
        float yBase = cy + radius * 1.55f;
        canvas.drawLine(cx - radius * 0.35f, yBase, cx + radius * 0.35f, yBase, paint);

        // Spark rays
        float sparkLen = sizePx * 0.08f;
        canvas.drawLine(cx, cy - radius - sparkLen, cx, cy - radius - 2, paint);
        canvas.drawLine(cx - radius - sparkLen, cy - radius * 0.2f, cx - radius - 2, cy - radius * 0.2f, paint);
        canvas.drawLine(cx + radius + 2, cy - radius * 0.2f, cx + radius + sparkLen, cy - radius * 0.2f, paint);

        return bitmap;
    }

    public static Bitmap createCloseIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 2.2f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float pad = sizePx * 0.28f;
        canvas.drawLine(pad, pad, sizePx - pad, sizePx - pad, paint);
        canvas.drawLine(sizePx - pad, pad, pad, sizePx - pad, paint);

        return bitmap;
    }

    public static Bitmap createTrashIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        float pad = sizePx * 0.22f;
        float w = sizePx - 2 * pad;
        float h = sizePx - 2 * pad;

        // Lid top handle
        float lidY = pad + h * 0.22f;
        float handleW = w * 0.36f;
        float handleLeft = (sizePx - handleW) / 2f;
        float handleH = h * 0.15f;
        canvas.drawRect(handleLeft, lidY - handleH, handleLeft + handleW, lidY, paint);

        // Lid bar
        canvas.drawLine(pad, lidY, sizePx - pad, lidY, paint);

        // Bin body
        float bodyLeft = pad + w * 0.12f;
        float bodyRight = sizePx - pad - w * 0.12f;
        float bodyBottom = sizePx - pad;
        Path body = new Path();
        body.moveTo(bodyLeft, lidY);
        body.lineTo(bodyLeft + w * 0.05f, bodyBottom);
        body.lineTo(bodyRight - w * 0.05f, bodyBottom);
        body.lineTo(bodyRight, lidY);
        canvas.drawPath(body, paint);

        // Ribs
        float lineTop = lidY + h * 0.22f;
        float lineBottom = bodyBottom - h * 0.15f;
        canvas.drawLine(sizePx / 2f, lineTop, sizePx / 2f, lineBottom, paint);
        canvas.drawLine(sizePx / 2f - w * 0.16f, lineTop, sizePx / 2f - w * 0.14f, lineBottom, paint);
        canvas.drawLine(sizePx / 2f + w * 0.16f, lineTop, sizePx / 2f + w * 0.14f, lineBottom, paint);

        return bitmap;
    }

    public static Bitmap createChatIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        float pad = sizePx * 0.22f;
        float w = sizePx - 2 * pad;
        float h = sizePx * 0.50f;

        // Rounded speech bubble with tail
        Path bubble = new Path();
        bubble.addRoundRect(new RectF(pad, pad, pad + w, pad + h), dpToPx(context, 4), dpToPx(context, 4), Path.Direction.CW);
        canvas.drawPath(bubble, paint);

        // Speech tail
        Path tail = new Path();
        tail.moveTo(pad + w * 0.25f, pad + h);
        tail.lineTo(pad + w * 0.15f, pad + h + sizePx * 0.14f);
        tail.lineTo(pad + w * 0.45f, pad + h);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(tail, paint);

        return bitmap;
    }

    public static Bitmap createHistoryIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float cx = sizePx / 2f;
        float cy = sizePx / 2f;
        float r = sizePx * 0.32f;

        // Clock circle
        canvas.drawCircle(cx, cy, r, paint);

        // Clock hands
        canvas.drawLine(cx, cy, cx, cy - r * 0.60f, paint);
        canvas.drawLine(cx, cy, cx + r * 0.45f, cy, paint);

        return bitmap;
    }

    public static Bitmap createLogoutIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        float pad = sizePx * 0.22f;
        float w = sizePx - 2 * pad;
        float h = sizePx - 2 * pad;

        // Door frame
        Path door = new Path();
        door.moveTo(pad + w * 0.50f, pad);
        door.lineTo(pad, pad);
        door.lineTo(pad, pad + h);
        door.lineTo(pad + w * 0.50f, pad + h);
        canvas.drawPath(door, paint);

        // Exit arrow pointing right
        float arrowY = pad + h / 2f;
        float arrowLeft = pad + w * 0.30f;
        float arrowRight = pad + w;
        canvas.drawLine(arrowLeft, arrowY, arrowRight, arrowY, paint);
        canvas.drawLine(arrowRight - w * 0.25f, arrowY - h * 0.20f, arrowRight, arrowY, paint);
        canvas.drawLine(arrowRight - w * 0.25f, arrowY + h * 0.20f, arrowRight, arrowY, paint);

        return bitmap;
    }

    public static Bitmap createClearIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float cx = sizePx / 2f;
        float cy = sizePx / 2f;
        float r = sizePx * 0.30f;

        // Circular sweep arc
        RectF oval = new RectF(cx - r, cy - r, cx + r, cy + r);
        canvas.drawArc(oval, 45, 270, false, paint);

        // Arrow head on sweep
        float arrowX = cx + r * (float) Math.cos(Math.toRadians(45));
        float arrowY = cy + r * (float) Math.sin(Math.toRadians(45));
        canvas.drawLine(arrowX, arrowY, arrowX - sizePx * 0.12f, arrowY - sizePx * 0.04f, paint);
        canvas.drawLine(arrowX, arrowY, arrowX - sizePx * 0.04f, arrowY - sizePx * 0.12f, paint);

        return bitmap;
    }

    public static Bitmap createSettingsIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float cx = sizePx / 2f;
        float cy = sizePx / 2f;
        float r = sizePx * 0.20f;
        canvas.drawCircle(cx, cy, r, paint);

        // 6 cogs
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(i * 60);
            float x1 = cx + (r + 1) * (float) Math.cos(angle);
            float y1 = cy + (r + 1) * (float) Math.sin(angle);
            float x2 = cx + (r + sizePx * 0.11f) * (float) Math.cos(angle);
            float y2 = cy + (r + sizePx * 0.11f) * (float) Math.sin(angle);
            canvas.drawLine(x1, y1, x2, y2, paint);
        }

        return bitmap;
    }

    public static Bitmap createAboutIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 1.8f));

        float cx = sizePx / 2f;
        float cy = sizePx / 2f;
        float r = sizePx * 0.32f;
        canvas.drawCircle(cx, cy, r, paint);

        paint.setStyle(Paint.Style.FILL);
        // "i" dot
        canvas.drawCircle(cx, cy - r * 0.40f, dpToPx(context, 1.6f), paint);

        // "i" stalk
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 2.0f));
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(cx, cy - r * 0.10f, cx, cy + r * 0.45f, paint);

        return bitmap;
    }

    public static Bitmap createSearchIconBitmap(Context context, int sizeDp, int color) {
        int sizePx = dpToPx(context, sizeDp);
        Bitmap bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(context, 2.0f));
        paint.setStrokeCap(Paint.Cap.ROUND);

        float cx = sizePx * 0.42f;
        float cy = sizePx * 0.42f;
        float radius = sizePx * 0.25f;

        // Magnifying glass circle
        canvas.drawCircle(cx, cy, radius, paint);

        // Handle line
        float startX = cx + radius * 0.7f;
        float startY = cy + radius * 0.7f;
        float endX = sizePx * 0.78f;
        float endY = sizePx * 0.78f;
        canvas.drawLine(startX, startY, endX, endY, paint);

        return bitmap;
    }
}