package com.redknot.fractal;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class Mandelbrot2 extends Fractal {

    public Mandelbrot2(int width, int height) {
        super(width, height);
    }

    @Override
    public int comR(int i, int j) {
        double a = 0, b = 0, c, d, n = 0;
        while ((c = a * a) + (d = b * b) < 4 && n++ < 880) {
            b = 2 * a * b + j * 8e-9 - .645411;
            a = c - d + i * 8e-9 + .356888;
        }
        return (int) (255 * Math.pow((n - 0) / 800, 3.0));
    }

    @Override
    public int comG(int i, int j) {
        double a = 0, b = 0, c, d, n = 0;
        while ((c = a * a) + (d = b * b) < 4 && n++ < 880) {
            b = 2 * a * b + j * 8e-9 - .645411;
            a = c - d + i * 8e-9 + .356888;
        }
        return (int) (255 * Math.pow((n - 0) / 800, .7));
    }

    @Override
    public int comB(int i, int j) {
        double a = 0, b = 0, c, d, n = 0;
        while ((c = a * a) + (d = b * b) < 4 && n++ < 880) {
            b = 2 * a * b + j * 8e-9 - .645411;
            a = c - d + i * 8e-9 + .356888;
        }
        return (int) (255 * Math.pow((n - 0) / 800, .5));
    }
}
