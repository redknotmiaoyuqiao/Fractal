package com.redknot.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.redknot.domain.Complex;
import com.redknot.domain.OperatorComplex;

/**
 * Created by miaoyuqiao on 16/4/17.
 */
public class JuliaSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    public JuliaSurfaceView(Context context,double real,double image,int times) {
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
        MyThread t = new MyThread(holder);
        new Thread(t).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    int icount = 1;        //迭代次数
    double c = 0;        //实部
    double d = 0;          //虚部

    private class MyThread implements Runnable {

        private SurfaceHolder holder;

        int[] colortab = new int[21];

        public MyThread(SurfaceHolder holder) {
            this.holder = holder;

            colortab[0] = Color.rgb(28, 28, 28);
            colortab[1] = Color.rgb(130, 130, 130);
            colortab[2] = Color.rgb(85, 26, 139);
            colortab[3] = Color.rgb(224, 102, 255);
            colortab[4] = Color.rgb(255, 187, 255);
            colortab[5] = Color.rgb(0, 0, 205);
            colortab[6] = Color.rgb(72, 118, 255);
            colortab[7] = Color.rgb(0, 191, 255);
            colortab[8] = Color.rgb(0, 255, 255);
            colortab[9] = Color.rgb(0, 255, 127);
            colortab[10] = Color.rgb(0, 255, 0);
            colortab[11] = Color.rgb(50, 205, 50);
            colortab[12] = Color.rgb(173, 255, 47);
            colortab[13] = Color.rgb(255, 185, 15);
            colortab[14] = Color.rgb(255, 215, 0);
            colortab[15] = Color.rgb(255, 255, 0);
            colortab[16] = Color.rgb(255, 69, 0);
            colortab[17] = Color.rgb(255, 140, 0);
            colortab[18] = Color.rgb(255, 211, 155);
            colortab[19] = Color.rgb(255, 231, 186);
            colortab[20] = Color.rgb(255, 239, 213);

            /*for (int i = 0; i < colortab.length; i++) {
                colortab[i] = Color.rgb(255, 255, 0 + i * (255 / colortab.length));
            }*/
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
            if (dist < 1.0 / 4096)
                return colortab[0];
            else if (dist < 1.0 / 1024)
                return colortab[1];
            else if (dist < 1.0 / 256)
                return colortab[2];
            else if (dist < 1.0 / 64)
                return colortab[3];
            else if (dist < 1.0 / 16)
                return colortab[4];
            else if (dist < 1.0 / 4)
                return colortab[5];
            else if (dist < 1)
                return colortab[6];
            else if (dist < 4)
                return colortab[7];
            else if (dist < 16)
                return colortab[8];
            else if (dist < 64)
                return colortab[9];
            else if (dist < 256)
                return colortab[10];
            else if (dist < 1024)
                return colortab[11];
            else if (dist < 4096)
                return colortab[12];
            else if (dist < 16384)
                return colortab[13];
            else if (dist < 65536)
                return colortab[14];
            else if (dist < 262144)
                return colortab[15];
            else if (dist < 1048576)
                return colortab[16];
            else if (dist < 4194304)
                return colortab[17];
            else if (dist < 16777216)
                return colortab[18];
            else if (dist < 67108864)
                return colortab[19];
            else return colortab[20];
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
