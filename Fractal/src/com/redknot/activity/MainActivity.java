package com.redknot.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.widget.Toast;

import com.redknot.weibo.Screen;
import com.redknot.weibo.ShareActivity;

public class MainActivity extends Activity {
	
	private MySurfaceView surfaceview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Intent intent = this.getIntent();

		MyHandler handler = new MyHandler();
		
		surfaceview = new MySurfaceView(handler, this);

		setContentView(surfaceview);
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);

		menu.add(0, 100, 0, "share");

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 100) {
			
			//Screen.Bmp = bitmap;

			Intent intent = new Intent(MainActivity.this, ShareActivity.class);
			startActivity(intent);
		
		}
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("HandlerLeak")
	private class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == 200) {
				Toast.makeText(MainActivity.this, "complete", Toast.LENGTH_LONG)
						.show();
			}
		}
	}
}
