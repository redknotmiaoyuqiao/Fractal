package com.redknot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.redknot.domain.PathList;
import com.redknot.domain.Point;

/**
 * Created by miaoyuqiao on 16/4/12.
 */
public class DrawPadSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private PathList path = new PathList();
    private SurfaceHolder holder = null;

    public void clearPath() {
        path.clearPath();
        draw();
    }

    public PathList getPath(){
        return this.path;
    }

    public DrawPadSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.getHolder().addCallback(this);
    }

    public DrawPadSurfaceView(Context context) {
        super(context);
        this.getHolder().addCallback(this);
    }

    public DrawPadSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.holder = holder;
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float x = event.getX();
            float y = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float x = event.getX();
            float y = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            float x = event.getX();
            float y = event.getY();
            path.addPoint(new Point(x, y));
        }
        draw();
        return true;
    }

    private void draw() {
        Canvas canvas = holder.lockCanvas();
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth((float) 3.0);
        paint.setStyle(Paint.Style.STROKE);

        for (int i = 0; i < path.getSize(); i++) {
            Point point_a = path.getPoint(i);

            int index_b = i+1;
            if(i+1 >= path.getSize()){
                index_b = i;
            }

            Point point_b = path.getPoint(index_b);
            paint.setColor(Color.BLACK);

            canvas.drawLine(point_a.getX(),point_a.getY(),point_b.getX(),point_b.getY(),paint);

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(point_a.getColor());
            canvas.drawCircle(point_a.getX(),point_a.getY(),20.0f,paint);
        }


        holder.unlockCanvasAndPost(canvas);
    }
}
