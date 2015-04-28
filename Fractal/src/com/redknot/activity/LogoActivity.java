package com.redknot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.redknot.fractal.R;

public class LogoActivity extends Activity{
	
	private ImageView logo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		
		logo = (ImageView) findViewById(R.id.logo);
		
		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(2000);
		logo.setAnimation(animation);
		
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LogoActivity.this,ListActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
