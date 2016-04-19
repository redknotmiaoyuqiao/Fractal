package com.redknot.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.redknot.fractal.Factory;
import com.redknot.fractal.Fractal;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class FractalSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private int id;
    private int width;
    private int height;

    public FractalSurfaceView(Context context, int id) {
        super(context);
        this.getHolder().addCallback(this);
        this.id = id;
    }

    public FractalSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.getHolder().addCallback(this);
    }

    public FractalSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.width = FractalSurfaceView.this.getWidth();
        this.height = FractalSurfaceView.this.getHeight();

        MyThread myThread = new MyThread(holder);
        new Thread(myThread).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private class MyThread implements Runnable {

        private SurfaceHolder holder;

        public MyThread(SurfaceHolder holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            Canvas c = new Canvas(bitmap);
            c.drawColor(Color.WHITE);
            Paint paint = new Paint();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Fractal fractal = Factory.getFractal(id, width, height);

                    paint.setColor(fractal.getColor(x, y));

                    c.drawPoint(x, y, paint);
                }

                try {
                    Canvas canvas = holder.lockCanvas();
                    canvas.drawBitmap(bitmap, 0, 0, paint);
                    holder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {
                    break;

                }

            }

        }
    }
}
