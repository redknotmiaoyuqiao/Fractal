package com.redknot.thread;

import java.util.HashMap;
import java.util.Map;

import android.os.Handler;
import android.os.Message;

import com.redknot.httputil.HttpUtil;
import com.redknot.httputil.UrlUtil;

public class LoginThread implements Runnable {

	private Handler handler;
	private String username;
	private String password;

	public LoginThread(Handler handler, String username, String password) {
		this.handler = handler;
		this.username = username;
		this.password = password;
	}

	@Override
	public void run() {
		Map<String, String> rawparams = new HashMap<String, String>();
		rawparams.put("username", username);
		rawparams.put("password", password);
		String url = UrlUtil.LOGIN_URL;
		// TODO Auto-generated method stub

		Message msg = new Message();
		try {
			String res = HttpUtil.postRequest(url, rawparams);
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
