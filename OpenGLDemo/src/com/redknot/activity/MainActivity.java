package com.redknot.activity;

import com.redknot.opengldemo.R;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivity extends Activity{
	
	private GLSurfaceView glsurfaceview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		glsurfaceview = (GLSurfaceView) findViewById(R.id.glsurfaceview);
		glsurfaceview.setRenderer(new GLSurfaceViewRenderer());
	}

}
