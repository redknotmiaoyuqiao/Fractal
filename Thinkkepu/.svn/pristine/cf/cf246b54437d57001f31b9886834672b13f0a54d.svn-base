package com.redknot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.redknot.thinkkepu.R;
import com.redknot.thread.GetClassListThread;

public class LogoActivity extends Activity {

	private ImageView logo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		
		GetClassListThread t = new GetClassListThread(this);
		new Thread(t).start();

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
				Intent intent = new Intent(LogoActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
