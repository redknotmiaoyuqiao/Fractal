package com.redknot.fractal;

import com.redknot.util.ID;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class Factory {

    private Factory() {

    }

    public static Fractal getFractal(int id, int width, int height) {
        if (id == ID.Mandelbrot) {
            return new Mandelbrot(width, height);
        }
        if (id == ID.Mandelbrot2) {
            return new Mandelbrot2(width, height);
        }
        if (id == ID.Mandelbrot3) {
            return new Mandelbrot3(width, height);
        }
        if (id == ID.Buddhabrot) {
            return new Buddhabrot(width, height);
        }
        if (id == ID.Julia) {
            return new Julia(width, height);
        }
        return null;
    }

}
