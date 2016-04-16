package com.redknot.fractal;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class Buddhabrot extends Fractal {
    public Buddhabrot(int width, int height) {
        super(width, height);
    }

    float x = 0, y = 0;

    @Override
    public int comR(int i, int j) {
       return 0;
    }

    @Override
    public int comG(int i, int j) {
        return 0;
    }

    @Override
    public int comB(int i, int j) {
        return 0;
    }
}
