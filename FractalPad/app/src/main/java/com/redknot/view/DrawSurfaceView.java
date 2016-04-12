package com.redknot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.redknot.domain.Point;

import java.util.ArrayList;

/**
 * Created by miaoyuqiao on 16/4/12.
 */
public class DrawSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private DrawThread drawThread = null;
    private ArrayList<Point> points = null;

    public DrawSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.getHolder().addCallback(this);
    }

    public DrawSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.getHolder().addCallback(this);
    }

    public DrawSurfaceView(Context context) {
        super(context);
        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth((float) 3.0);
        paint.setStyle(Paint.Style.STROKE);

        drawThread = new DrawThread(holder,paint);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void startDraw(){
        new Thread(this.drawThread).start();
    }

    public void setPoint(ArrayList<Point> points){
        this.points = points;
    }

    private class DrawThread implements Runnable{

        private SurfaceHolder holder;
        private Paint paint;

        public DrawThread(SurfaceHolder holder,Paint paint){
            this.holder = holder;
            this.paint = paint;
        }
        @Override
        public void run() {

        }
    }
}
