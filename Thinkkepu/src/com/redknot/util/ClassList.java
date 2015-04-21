package com.redknot.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class ClassList {

	private Context context;

	public ClassList(Context context) {
		this.context = context;
	}

	public void setList(String list) {
		SharedPreferences sp = this.context.getSharedPreferences("think",
				Activity.MODE_PRIVATE);
		try {
			JSONArray ja = new JSONArray(list);
			JSONObject jo = ja.getJSONObject(ja.length()-1);
			jo.getString("kepu_sort_name");
			jo.getInt("kepu_sort_id");
			
			SharedPreferences.Editor editor = sp.edit();
			editor.putString("list", list);
			editor.commit();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ClassListDomain> getList() {
		SharedPreferences sp = this.context.getSharedPreferences("think",
				Activity.MODE_PRIVATE);
		String res = sp.getString("list", "[]");
		List<ClassListDomain> list = new ArrayList<ClassListDomain>();
		try {
			JSONArray ja = new JSONArray(res);
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.getJSONObject(i);
				ClassListDomain cld = new ClassListDomain(jo.getString("kepu_sort_name"), jo.getInt("kepu_sort_id"));
				list.add(cld);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
