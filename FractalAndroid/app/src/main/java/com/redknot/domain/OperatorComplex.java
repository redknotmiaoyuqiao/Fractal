package com.redknot.domain;

/**
 * Created by miaoyuqiao on 16/4/17.
 */
public class OperatorComplex {
    public OperatorComplex() {
    }

    public Complex Add(Complex complex_a, Complex complex_b) {
        double real = complex_a.getReal() + complex_b.getReal();
        double image = complex_a.getImage() + complex_b.getReal();
        Complex c = new Complex(real, image);
        return c;
    }

    public Complex Mult(Complex complex_a, Complex complex_b) {
        double real = complex_a.getReal() * complex_b.getReal() - complex_a.getImage() * complex_b.getImage();
        double image = complex_a.getImage() * complex_b.getReal() + complex_a.getReal() * complex_b.getImage();
        Complex c = new Complex(real, image);
        return c;
    }

    public double Model(Complex complex) {
        return Math.sqrt(complex.getReal() * complex.getReal() + complex.getImage() * complex.getImage());
    }
}
