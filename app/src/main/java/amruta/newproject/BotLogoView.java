package amruta.newproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Custom View to display the official ChAI logo emblem with high-resolution
 * hardware-accelerated rendering and smooth aspect-ratio preservation.
 */
public class BotLogoView extends View {

    private boolean showText = false;
    private Paint paint;
    private static Bitmap sIconBitmap;

    public BotLogoView(Context context) {
        super(context);
        init();
    }

    public BotLogoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setShowText(boolean showText) {
        this.showText = showText;
        invalidate();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        loadBitmaps(getContext());
    }

    private static synchronized void loadBitmaps(Context context) {
        if (sIconBitmap == null && context != null) {
            try {
                sIconBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_chai_icon);
            } catch (Exception ignored) {}
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();
        if (w == 0 || h == 0) return;

        if (sIconBitmap == null) {
            loadBitmaps(getContext());
        }

        if (sIconBitmap != null) {
            float bw = sIconBitmap.getWidth();
            float bh = sIconBitmap.getHeight();

            float scale = Math.min((float) w / bw, (float) h / bh);
            float drawW = bw * scale;
            float drawH = bh * scale;
            float left = (w - drawW) / 2f;
            float top = (h - drawH) / 2f;

            Rect srcRect = new Rect(0, 0, (int) bw, (int) bh);
            RectF dstRect = new RectF(left, top, left + drawW, top + drawH);
            canvas.drawBitmap(sIconBitmap, srcRect, dstRect, paint);
        } else {
            // Fallback: draw circular badge
            paint.setColor(Color.parseColor("#050811"));
            paint.setStyle(Paint.Style.FILL);
            float radius = Math.min(w, h) / 2f;
            canvas.drawCircle(w / 2f, h / 2f, radius, paint);
        }
    }
}
