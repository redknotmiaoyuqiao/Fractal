package com.redknot.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Intent intent = this.getIntent();
		int id = intent.getIntExtra("id", 0);
		int color = intent.getIntExtra("color", 0);
		int n = intent.getIntExtra("n", 1);
		
		setContentView(new MySurfaceView(this,id,n,color));
	}
}
