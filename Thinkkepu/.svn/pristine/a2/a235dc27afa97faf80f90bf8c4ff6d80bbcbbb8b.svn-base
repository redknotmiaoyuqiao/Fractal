package com.redknot.util;

import android.content.Context;
import android.widget.Toast;

public class MyToast {

	private Context context;
	
	public MyToast(Context context){
		this.context = context;
	}
	
	public void show(String text){
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}
	
	public void show(int resId){
		String text = this.context.getText(resId).toString();
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}
}
