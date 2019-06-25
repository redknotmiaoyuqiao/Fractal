package com.redknot.julia;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class JuliaAnimationView extends GLSurfaceView {

    private JuliaGlRender juliaGlRender = null;

    public JuliaAnimationView(Context context) {
        super(context);
        setEGLContextClientVersion(3);
        juliaGlRender = new JuliaGlRender();
        this.setRenderer(juliaGlRender);
    }

    public JuliaAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setEGLContextClientVersion(3);
        juliaGlRender = new JuliaGlRender();
        this.setRenderer(juliaGlRender);
    }
}
