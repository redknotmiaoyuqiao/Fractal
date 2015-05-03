package com.redknot.thread;

import java.util.Map;

import android.os.Handler;
import android.os.Message;

import com.redknot.httputil.HttpUtil;
import com.redknot.httputil.UrlUtil;

public class SendCommentThread implements Runnable {

	private Map<String, String> rawparams;
	private Handler handler;

	public SendCommentThread(Map<String, String> rawparams, Handler handler) {
		this.rawparams = rawparams;
		this.handler = handler;
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		String url = UrlUtil.SEND_COMMENT;
		Message msg = new Message();
		try {
			String res = HttpUtil.postRequest(url, this.rawparams);
			msg.what = 200;
			msg.obj = res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.what = 400;
		}
		
		this.handler.sendMessage(msg);
	}

}
