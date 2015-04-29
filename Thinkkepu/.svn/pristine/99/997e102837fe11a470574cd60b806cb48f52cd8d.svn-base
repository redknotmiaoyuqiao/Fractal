package com.redknot.httputil;

import android.os.Handler;
import android.os.Message;

public abstract class MyHandler extends Handler{
	@Override
	public void handleMessage(Message msg) {
		if(msg.what == 200){
			String res = "";
			if(msg.obj == null){
				res = "";
			}
			else{
				res = (String)msg.obj;
			}
			success(res);
		}
		else if(msg.what == 400){
			fail();
		}
	}
	public abstract void fail();
	public abstract void success(String res);
}
