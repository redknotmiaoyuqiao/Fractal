package com.redknot.fractal;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class Mandelbrot3 extends Fractal {
    public Mandelbrot3(int width, int height) {
        super(width, height);
    }

    private int tempR = 0;

    @Override
    public int comR(int i, int j) {
        double a = 0, b = 0, d, n = 0;
        for (; a * a + (d = b * b) < 4 && n++ < 8192; b = 2 * a * b + j / 5e4 + .06, a = a * a - d + i / 5e4 + .34)
            ;
        tempR = (int) (n / 4);
        return tempR;
    }

    @Override
    public int comG(int i, int j) {
        return 2 * tempR;
    }

    @Override
    public int comB(int i, int j) {
        return 4 * tempR;
    }
}
