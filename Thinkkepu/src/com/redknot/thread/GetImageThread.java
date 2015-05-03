package com.redknot.thread;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

import com.redknot.httputil.HttpUtil;
import com.redknot.util.ImageUtil;

public class GetImageThread implements Runnable{
	
	private Handler handler;
	private String url;
	
	public GetImageThread(Handler handler,String url){
		this.handler = handler;
		this.url = url;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Message msg = new Message();
		try {
			Bitmap bitmap = HttpUtil.loadImage(this.url);
			
			bitmap = ImageUtil.ChangeSizeBitMap(bitmap,200);
			
			msg.obj = bitmap;
			msg.what = 200;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.what = 400; 
		}
		this.handler.sendMessage(msg);
	}
	
	

}
