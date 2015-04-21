package com.redknot.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class LoginSession {
	private Context context;

	public LoginSession(Context context) {
		this.context = context;
	}

	public String getSession() {
		SharedPreferences sp = this.context.getSharedPreferences("think",
				Activity.MODE_PRIVATE);
		String res = sp.getString("session", "<nano>");
		return res;
	}

	public void setSession(String session) {
		SharedPreferences sp = this.context.getSharedPreferences("think",
				Activity.MODE_PRIVATE);

		SharedPreferences.Editor editor = sp.edit();
		editor.putString("session", session);
		editor.commit();
	}
}
