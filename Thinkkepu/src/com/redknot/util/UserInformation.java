package com.redknot.util;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class UserInformation {
	private String username;
	private String login_session;
	private Context context;

	public UserInformation(Context context) {
		this.username = "";
		this.login_session = "";
		this.context = context;
	}

	public void setUser(String res) {

		String username;
		String login_session;

		try {
			JSONObject jo = new JSONObject(res);
			username = jo.getString("username");
			login_session = jo.getString("session");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		SharedPreferences sp = this.context.getSharedPreferences("think",
				Activity.MODE_PRIVATE);

		SharedPreferences.Editor editor = sp.edit();
		editor.putString("session", login_session);
		editor.putString("username", username);
		editor.commit();
	}

	public String getUsername() {
		SharedPreferences sp = this.context.getSharedPreferences("think",
				Activity.MODE_PRIVATE);
		String res = sp.getString("username", "");
		return res;
	}

	public String getLogin_session() {
		SharedPreferences sp = this.context.getSharedPreferences("think",
				Activity.MODE_PRIVATE);
		String res = sp.getString("session", "");
		return res;
	}

}
