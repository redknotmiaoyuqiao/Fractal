package com.redknot.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.redknot.fractal.Factory;
import com.redknot.fractal.Fractal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class FractalSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private int id;
    private int width;
    private int height;
    private Fractal fractal;
    private int step = 2;

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
        this.fractal = Factory.getFractal(id, width, height);

        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);
        getHolder().unlockCanvasAndPost(canvas);

        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i=0; i<height/step; i++){
            final int finalI = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap = getBitmap(finalI);
                    drawCanvas(finalI, bitmap);

                }
            });
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private Bitmap getBitmap(int yPos){
        Bitmap bitmap = Bitmap.createBitmap(width, step, Bitmap.Config.RGB_565);
        for (int y = yPos * step; y < (yPos+1) * step ; y++) {
            for (int x = 0; x < width; x++) {
                bitmap.setPixel(x, y % step, fractal.getColor(x, y));
            }
        }
        return bitmap;
    }

    synchronized private void drawCanvas(int yPos, Bitmap bitmap){
        try {
            Canvas canvas = getHolder().lockCanvas(new Rect(0, yPos * step, width, (yPos+1) * step));
            canvas.drawBitmap(bitmap, 0, yPos * step, null);
            getHolder().unlockCanvasAndPost(canvas);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
