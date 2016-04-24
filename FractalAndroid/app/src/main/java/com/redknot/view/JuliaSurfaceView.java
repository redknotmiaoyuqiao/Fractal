package com.redknot.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.redknot.domain.Complex;
import com.redknot.domain.OperatorComplex;

/**
 * Created by miaoyuqiao on 16/4/17.
 */
public class JuliaSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private int icount = 1;        //迭代次数
    private double c = 0;        //实部
    private double d = 0;          //虚部

    private SurfaceHolder holder;

    public JuliaSurfaceView(Context context, double real, double image, int times) {
        super(context);
        this.getHolder().addCallback(this);

        this.c = real;
        this.d = image;
        this.icount = times;
    }

    public JuliaSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.getHolder().addCallback(this);
    }

    public JuliaSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        this.holder = holder;

        MyThread t = new MyThread(holder);
        new Thread(t).start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            /*Canvas c = new Canvas(bitmap);
            Paint p = new Paint();
            p.setColor(Color.WHITE);
            c.drawCircle(event.getX(),event.getY(),15.0f,p);

            Canvas canvas = holder.lockCanvas();
            canvas.drawBitmap(bitmap, 0, 0, p);
            holder.unlockCanvasAndPost(canvas);*/
        }

        return true;
    }


    private class MyThread implements Runnable {

        private SurfaceHolder holder;

        public MyThread(SurfaceHolder holder) {
            this.holder = holder;
        }

        double Iteration(Complex a, int n) {
            OperatorComplex o = new OperatorComplex();

            if (n == 0) {
                return o.Model(a);
            } else {
                Complex temp = o.Mult(a, a);

                temp.setReal(temp.getReal() + c);
                temp.setImage(temp.getImage() + d);

                return Iteration(temp, n - 1);
            }
        }

        int dye(double dist) {

            int r = (int) (Math.log(dist) * 47);
            int g = (int) (Math.log(dist) * 47);
            int b = (int) (128 - Math.log(dist) * 23);

            if (r > 255) {
                r = 255;
            }
            if (r < 0) {
                r = 0;
            }
            if (g > 255) {
                g = 255;
            }
            if (g < 0) {
                g = 0;
            }

            if (b > 255) {
                b = 255;
            }
            if (b < 0) {
                b = 0;
            }

            return Color.rgb(r & 255, g & 255, b & 255);

        }


        @Override
        public void run() {

            int width = JuliaSurfaceView.this.getWidth();
            int height = JuliaSurfaceView.this.getHeight();

            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            Canvas c = new Canvas(bitmap);
            c.drawColor(Color.WHITE);
            Paint paint = new Paint();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    double _x = (x - width / 2.0) / (width / 2.0);
                    double _y = (y - height / 2.0) / (width / 2.0);

                    Complex a = new Complex(_x, _y);

                    double dist = Iteration(a, icount);

                    int color = dye(dist);

                    paint.setColor(color);
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
