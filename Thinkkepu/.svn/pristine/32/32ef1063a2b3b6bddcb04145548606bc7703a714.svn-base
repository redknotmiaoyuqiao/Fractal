package com.redknot.model;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;

public class Article {
	private int id;
	private int time;
	private String title;
	private String author;
	private String show;
	private String img_url;
	private Bitmap img;
	private String a_class;
	private String content;
	
	public Article(){
		this.id = -1;
		this.time = 0;
		this.title = "";
		this.author = "";
		this.show = "";
		this.img_url = "";
		this.img = null;
		this.a_class = "";
		this.content = "";
	}
	
	public Article(JSONObject jo){
		try {
			this.setId(jo.getInt("kepu_art_id"));
			this.setTitle(jo.getString("kepu_art_title"));
			this.setAuthor(jo.getString("kepu_art_author"));
			this.setShow(jo.getString("kepu_art_show"));
			this.setImg_url(jo.getString("kepu_art_img"));
			this.setA_class(jo.getString("kepu_art_class"));
			this.setTime(jo.getInt("kepu_art_time"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setTime(0);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getA_class() {
		return a_class;
	}
	public void setA_class(String a_class) {
		this.a_class = a_class;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Bitmap getImg() {
		return img;
	}
	public void setImg(Bitmap img) {
		this.img = img;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
