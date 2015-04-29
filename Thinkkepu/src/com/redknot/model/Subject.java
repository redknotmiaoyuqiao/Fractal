package com.redknot.model;

import org.json.JSONObject;

import android.graphics.Bitmap;

public class Subject {
	private String title;
	private String show;
	private String img_url;
	private Bitmap img;
	private String url;
	private long time;

	public Subject(){
		this.setTime(0);
		this.setTitle("");
		this.setImg_url("");
		this.setImg(null);
		this.setUrl("");
		this.setShow("");
	}
	public Subject(JSONObject jo){
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Bitmap getImg() {
		return img;
	}

	public void setImg(Bitmap img) {
		this.img = img;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
