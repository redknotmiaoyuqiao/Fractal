package com.redknot.fractal;

import com.redknot.util.ID;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class Factory {

    private Factory() {

    }

    public static Fractal getFractal(int id, int width, int height) {
        if (id == ID.Mandborlt) {
            return new Mandborlt(width, height);
        }
        return null;
    }

}
