package com.redknot.julia;

public class JuliaJNI {
    static {
        System.loadLibrary("julia-lib");
    }
    public static native void CreateJulia(int width,int height);
    public static native void CreateOnFrame();
}
