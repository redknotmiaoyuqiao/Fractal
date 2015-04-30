package com.redknot.activity;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.redknot.thread.DrawMainThread;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{
	
    

	private SurfaceHolder holder;
	private int id;
	private int n;
	private int color;
	private Handler handler;
	
	public MySurfaceView(Handler handler,Context context,int id,int n,int color) {
		super(context);
		// TODO Auto-generated constructor stub
		this.holder = this.getHolder();
		this.holder.addCallback(this);
		this.id = id;
		this.n = n;this.color = color;
		//this.setBackgroundColor(Color.WHITE);
		this.handler = handler;
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		
		
		
		// TODO Auto-generated method stub
		DrawMainThread t = new DrawMainThread(this.handler,this.holder,getWidth(),getHeight(),this.color,this.id,this.n);
		new Thread(t).start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
