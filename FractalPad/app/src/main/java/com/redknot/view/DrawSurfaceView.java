package com.redknot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.redknot.domain.Point;
import com.redknot.fractalpad.DrawActivity;

import java.util.ArrayList;

/**
 * Created by miaoyuqiao on 16/4/12.
 */
public class DrawSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private DrawThread drawThread = null;
    private ArrayList<Point> points = null;
    private Path path = new Path();

    private int width;
    private int height;

    private SurfaceHolder holder = null;

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

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.holder = holder;

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth((float) 3.0);
        paint.setStyle(Paint.Style.STROKE);

        this.drawThread = new DrawThread(holder, paint);
        startDraw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void startDraw() {
        new Thread(drawThread).start();
    }

    private class DrawThread implements Runnable {

        private SurfaceHolder holder;
        private Paint paint;

        public DrawThread(SurfaceHolder holder, Paint paint) {
            this.holder = holder;
            this.paint = paint;
        }

        @Override
        public void run() {
            draw(DrawActivity.points, 1, this.holder, path, paint);
        }

        private double getLength(Point a, Point b) {

            double length_x = a.getX() - b.getX();
            double length_y = a.getY() - b.getY();

            double _length_first_last = Math.sqrt((length_x * length_x) + (length_y * length_y));
            return _length_first_last;
        }


        private Point getPoint(Point A, Point B, Point C) {

            float a = (float) getLength(B, C);
            float b = (float) getLength(A, C);
            float c = (float) getLength(A, B);


            float cos = (c * c + b * b - a * a) / (2 * b * c);
            float sin = -(float) Math.sqrt(1 - cos * cos);

            float x = (C.getX() - A.getX()) * cos - (C.getY() - A.getY()) * sin + A.getX();
            float y = (C.getX() - A.getX()) * sin + (C.getY() - A.getY()) * cos + A.getY();


            return new Point(x * (b / c), y * (b / c));
        }

        private void draw(ArrayList<Point> last_point_computer, int n, SurfaceHolder holder, Path path, Paint p) {

            ArrayList<Point> point_computer = new ArrayList<>();

            point_computer.add(last_point_computer.get(0));

            for (int i = 1; i < last_point_computer.size() - 1; i++) {
                //起点和终点
                Point A = last_point_computer.get(0);
                Point B = last_point_computer.get(last_point_computer.size() - 1);
                //要计算的点的模版点
                Point C = last_point_computer.get(i);

                Point cc = getPoint(A, B, C);
                point_computer.add(cc);

                Log.e("aaaaa", "bbbbbb");
            }

            point_computer.add(last_point_computer.get(last_point_computer.size() - 1));

            if (n > 1) {
                for (int i = 0; i < point_computer.size() - 1; i++) {
                    draw(point_computer, n - 1, holder, path, p);
                }
            } else {
                for (int i = 0; i < point_computer.size(); i++) {
                    int x = (int) point_computer.get(i).getX();
                    int y = (int) point_computer.get(i).getY();
                    if (path.isEmpty()) {
                        path.moveTo(x, y);
                        Log.e("xy", "x:" + x + "   y:" + y);
                    } else {
                        path.lineTo(x, y);
                        Log.e("xy", "x:" + x + "   y:" + y);
                    }
                }
                try {
                    Canvas canvas = holder.lockCanvas();

                    canvas.drawColor(Color.WHITE);
                    canvas.drawPath(path, p);

                    holder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {

                }
            }


        }
    }
}
