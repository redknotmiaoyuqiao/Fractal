package com.redknot.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.redknot.model.Subject;
import com.redknot.thinkkepu.R;

public class SubjectAdapter extends BaseAdapter{
	
	private List<Subject> data;
	private Context context;
	
	public SubjectAdapter(List<Subject> data, Context context){
		this.data = data;
		this.context = context;
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = null;
		view = inflater.inflate(R.layout.listview_subject, null);
		return view;
	}

}
