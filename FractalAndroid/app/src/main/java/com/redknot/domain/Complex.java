package com.redknot.domain;

/**
 * Created by miaoyuqiao on 16/4/17.
 */
public class Complex {
    private double real;
    private double image;

    public Complex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }
}
