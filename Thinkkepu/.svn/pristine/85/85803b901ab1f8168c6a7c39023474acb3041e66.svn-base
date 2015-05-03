package com.redknot.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.redknot.thinkkepu.R;

public class MainMenuListViewAdapter extends BaseAdapter{

	private Context context;
	private List<String> data;

	public MainMenuListViewAdapter(Context context) {
		this.context = context;
		data.add("first");
		data.add("first");
		data.add("first");
		data.add("first");
		data.add("first");
		data.add("first");
		data.add("first");
		data.add("first");
		data.add("first");
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.data.size();
	}

	@Override
	public Object getItem(int i) {
		// TODO Auto-generated method stub
		return this.data.get(i);
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i;
	}

	@SuppressLint({ "ViewHolder", "InflateParams" }) 
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = null;
		
		view = inflater.inflate(R.layout.listview_main_menu, null);
		
		return view;
	}

}
