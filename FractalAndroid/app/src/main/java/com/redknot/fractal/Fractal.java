package com.redknot.fractal;

import android.graphics.Color;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public abstract class Fractal {

    public int width;
    public int height;

    public Fractal(int width,int height){
        this.width = width;
        this.height = height;
    }

    public int getColor(int i, int j) {
        return Color.rgb(comR(i, j) & 255, comG(i, j) & 255, comB(i, j) & 255);
    }

    public abstract int comR(int i, int j);

    public abstract int comG(int i, int j);

    public abstract int comB(int i, int j);

}
