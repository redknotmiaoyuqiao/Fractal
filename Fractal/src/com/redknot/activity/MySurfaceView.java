package com.redknot.activity;

import com.redknot.thread.BitmapThread;
import com.redknot.thread.DrawThread;

import android.content.Context;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {

	private SurfaceHolder holder;

	private Handler handler;

	public MySurfaceView(Handler handler, Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.holder = this.getHolder();
		this.holder.addCallback(this);

		// this.setBackgroundColor(Color.WHITE);
		this.handler = handler;

	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {

		// TODO Auto-generated method stub
//		DrawThread tt = new DrawThread(this.holder);
//		new Thread(tt).start();
		
		BitmapThread b = new BitmapThread(handler, this.holder,
				this.getWidth(), this.getHeight());
		new Thread(b).start();

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub

	}

}
