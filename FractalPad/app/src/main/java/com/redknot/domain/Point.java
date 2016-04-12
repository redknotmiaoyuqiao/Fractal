package com.redknot.domain;

import android.graphics.Color;

/**
 * Created by miaoyuqiao on 16/4/12.
 */
public class Point {
    private float x;
    private float y;
    private int color;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;

        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        this.color = Color.rgb(r, g, b);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
