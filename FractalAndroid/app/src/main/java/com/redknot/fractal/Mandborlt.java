package com.redknot.fractal;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class Mandborlt extends Fractal {

    public Mandborlt(int width, int height) {
        super(width, height);
    }

    int n = 4;

    @Override
    public int comR(int i, int j) {
        float x = 0, y = 0;
        int k;
        for (k = 0; k++ < 256; ) {
            float a = (float) (x * x - y * y + (i - width * (3.0 / 4.0)) / (width / 2.0));
            y = (float) (2 * x * y + (j - (height / 2.0)) / (width / 2.0));
            x = a;
            if (x * x + y * y > n) {
                break;
            }
        }
        return (int) (Math.log(k) * 47);
    }

    @Override
    public int comG(int i, int j) {
        float x = 0, y = 0;
        int k;
        for (k = 0; k++ < 256; ) {
            float a = (float) (x * x - y * y + (i - width * (3.0 / 4.0)) / (width / 2.0));
            y = (float) (2 * x * y + (j - (height / 2.0)) / (width / 2.0));
            x = a;
            if (x * x + y * y > n) {
                break;
            }
        }
        return (int) (Math.log(k) * 47);
    }

    @Override
    public int comB(int i, int j) {
        float x = 0, y = 0;
        int k;
        for (k = 0; k++ < 256; ) {
            float a = (float) (x * x - y * y + (i - width * (3.0 / 4.0)) / (width / 2.0));
            y = (float) (2 * x * y + (j - (height / 2.0)) / (width / 2.0));
            x = a;
            if (x * x + y * y > n) {
                break;
            }
        }
        return (int) (128 - Math.log(k) * 23);
    }
}
