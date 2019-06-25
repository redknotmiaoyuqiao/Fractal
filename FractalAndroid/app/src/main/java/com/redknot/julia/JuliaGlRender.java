package com.redknot.julia;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class JuliaGlRender implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int w, int h) {
        JuliaJNI.CreateJulia(w,h);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        JuliaJNI.CreateOnFrame();
    }
}
