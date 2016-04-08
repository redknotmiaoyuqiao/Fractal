package com.redknot.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.redknot.fractalandroid.R;
import com.redknot.g.G;

public class SettingActivity extends AppCompatActivity {
	
	private SeekBar red;
	private SeekBar blue;
	private SeekBar green;
	
	private TextView tv_red;
	private TextView tv_blue;
	private TextView tv_green;
	
	private Button submit;
	
	//private int id = 0;
	
	private SeekBar time;
	private TextView tv_time;
	
	private ImageView color_show;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		//id = getIntent().getIntExtra("id", 0);
		
		init();
	}
	
	private class MyOnSeekBarChangeListener implements OnSeekBarChangeListener{

		@Override
		public void onProgressChanged(SeekBar seek, int i, boolean arg2) {
			// TODO Auto-generated method stub
			if(seek == red){
				tv_red.setText("R:" + i);
			}
			if(seek == green){
				tv_green.setText("G:" + i);
			}
			if(seek == blue){
				tv_blue.setText("B:" + i);
			}
			if(seek == time){
				tv_time.setText("time:" + i);
			}
			
			
			
			Bitmap bitmap = Bitmap.createBitmap(50, 50, Config.ARGB_8888);
			Canvas canvas =  new Canvas(bitmap);
			canvas.drawColor(Color.rgb(red.getProgress(), green.getProgress(), blue.getProgress()));
			color_show.setImageBitmap(bitmap);
			
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private void init(){
		submit = (Button) findViewById(R.id.submit);
		color_show = (ImageView) findViewById(R.id.color_show);
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SettingActivity.this,MainActivity.class);
				
				G.n = time.getProgress();
				G.color = Color.rgb(red.getProgress(), green.getProgress(), blue.getProgress());
				
				startActivity(intent);
			}
		});
		
		time = (SeekBar) findViewById(R.id.time);
		tv_time = (TextView) findViewById(R.id.tv_time);
		tv_time.setText("time:0");
		time.setMax(20);
		
		time.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
		
		red = (SeekBar) findViewById(R.id.red);
		blue = (SeekBar) findViewById(R.id.blue);
		green = (SeekBar) findViewById(R.id.green);
		
		tv_red = (TextView) findViewById(R.id.tv_red);
		tv_blue = (TextView) findViewById(R.id.tv_blue);
		tv_green = (TextView) findViewById(R.id.tv_green);
		
		tv_red.setText("R:0");
		tv_blue.setText("B:0");
		tv_green.setText("G:0");
		
		red.setMax(255);
		blue.setMax(255);
		green.setMax(255);
		
		red.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
		blue.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
		green.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
		
		Bitmap bitmap = Bitmap.createBitmap(50, 50, Config.ARGB_8888);
		Canvas canvas =  new Canvas(bitmap);
		canvas.drawColor(Color.rgb(red.getProgress(), green.getProgress(), blue.getProgress()));
		color_show.setImageBitmap(bitmap);
	}
}
