package com.redknot.thread;

import android.os.Handler;
import android.os.Message;

import com.redknot.httputil.HttpUtil;
import com.redknot.httputil.UrlUtil;

public class GetArticleListThread implements Runnable{
	
	private Handler handler;
	private int i;
	private int size;
	
	public GetArticleListThread(Handler handler,int i,int size){
		this.handler = handler;
		this.i = i;
		this.size = size;
	}
	
	public GetArticleListThread(Handler handler,int i){
		this.handler = handler;
		this.i = i;
		this.size = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Message msg = new Message();
		try {
			String res = HttpUtil.getRequest(UrlUtil.GET_MAIN_LIST + "?id=" + this.i + "&size=" + this.size);
			msg.obj = res;
			msg.what = 200;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.what = 400;
		}
		this.handler.sendMessage(msg);
	}

}
