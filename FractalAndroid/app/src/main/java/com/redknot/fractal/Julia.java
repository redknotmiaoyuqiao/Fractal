package com.redknot.fractal;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class Julia extends Fractal {
    public Julia(int width, int height) {
        super(width, height);
    }

    private float D(float x) {
        return (float) ((x - width / 2.) / (width / 2.));
    }

    @Override
    public int comR(int i, int j) {
        float x = D(i), y = D(j), X, Y, n = 0;
        while (n++ < 200 && (X = x * x) + (Y = y * y) < 4) {
            x = (float) (X - Y + .36237);
            y = (float) (2 * x * y + .32);
        }
        return (int) (Math.log(n) * 256);
    }

    @Override
    public int comG(int i, int j) {
        float x = D(i), y = D(j), X, Y, n = 0;
        while (n++ < 200 && (x * x + y * y) < 4) {
            X = x;
            Y = y;
            x = (float) (X * X - Y * Y + -.7);
            y = (float) (2 * X * Y + .27015);
        }
        return (int) (Math.log(n) * 128);
    }

    @Override
    public int comB(int i, int j) {
        float x = D(i), y = D(j), X, Y, n = 0;
        while (n++ < 600 && (x * x + y * y) < 4) {
            X = x;
            Y = y;
            x = (float) (X * X - Y * Y + .36237);
            y = (float) (2 * X * Y + .32);
        }
        return (int) (Math.log(n) * 128);
    }
}
