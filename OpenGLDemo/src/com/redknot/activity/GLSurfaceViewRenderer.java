package com.redknot.activity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;

public class GLSurfaceViewRenderer implements GLSurfaceView.Renderer{
	
	float[] triangleData = new float[]{
		0.1f,0.6f,0.0f,
		-0.3f,0.0f,0.0f,
		0.3f,0.1f,0.0f
	};
	
	int[] triangleColor = new int[]{
		65535,0,0,0,
		0,65535,0,0,
		0,0,65535,0
	};
	
	private IntBuffer intBufferUtil(int[] arr){
		IntBuffer intBuffer;
		ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
		qbb.order(ByteOrder.nativeOrder());
		intBuffer = qbb.asIntBuffer();
		intBuffer.put(arr);
		intBuffer.position(0);
		return intBuffer;
	}
	
	private FloatBuffer floatBufferUtil(float[] arr){
		FloatBuffer floatBuffer;
		ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
		qbb.order(ByteOrder.nativeOrder());
		floatBuffer = qbb.asFloatBuffer();
		floatBuffer.put(arr);
		floatBuffer.position(0);
		return floatBuffer;
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
		gl.glLoadIdentity();
		
		gl.glTranslatef(-0.32f, 0.35f, -1f);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, floatBufferUtil(triangleData));
		gl.glColorPointer(3, GL10.GL_FIXED, 0, intBufferUtil(triangleColor));
		gl.glDrawArrays(GL10.GL_TRIANGLES, 2, 3);
		
		gl.glFinish();
		
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		float ratio = (float)width/height;
		gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		gl.glDisable(GL10.GL_DITHER);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		gl.glClearColor(0, 0, 0, 0);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}

}
