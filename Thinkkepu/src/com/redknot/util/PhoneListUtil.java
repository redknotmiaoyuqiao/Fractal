package com.redknot.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.redknot.model.Article;

public class PhoneListUtil {
	
	private Context context;

	public PhoneListUtil(Context context) {
		this.context = context;
	}
	
	public ArrayList<Article> getList(int id){
		String key = "phone_list_" + id;
		SharedPreferences sp = this.context.getSharedPreferences("think_list",
				Activity.MODE_PRIVATE);
		String res = sp.getString(key, "[]");
		
		ArrayList<Article> list = new ArrayList<Article>();
		
		try {
			JSONArray ja = new JSONArray(res);
			for(int i=0;i<ja.length();i++){
				JSONObject jo = ja.getJSONObject(i);
				Article a = new Article(jo);
				list.add(a);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void saveList(List<Article> list ,int id){
		JSONArray ja = new JSONArray();
		for(Article a : list){
			JSONObject jo = new JSONObject();
			try {
				jo.put("kepu_art_id", a.getId());
				jo.put("kepu_art_title", a.getTitle());
				jo.put("kepu_art_author", a.getAuthor());
				jo.put("kepu_art_show", a.getShow());
				jo.put("kepu_art_img", a.getImg_url());
				jo.put("kepu_art_class", a.getA_class());
				jo.put("kepu_art_time", a.getTime());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ja.put(jo);
		}
		String res = ja.toString();
		
		String key = "phone_list_" + id;
		String value = res;
		SharedPreferences sp = this.context.getSharedPreferences("think_list",
				Activity.MODE_PRIVATE);

		SharedPreferences.Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	public void saveList(String list ,int id){
		String key = "phone_list_" + id;
		String value = list;
		SharedPreferences sp = this.context.getSharedPreferences("think_list",
				Activity.MODE_PRIVATE);

		SharedPreferences.Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}
}
