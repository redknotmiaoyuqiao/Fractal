package com.redknot.activity;


import com.redknot.fractal.R;
import com.redknot.weibo.ShareActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Intent intent = this.getIntent();

		MyHandler handler = new MyHandler();

		setContentView(new MySurfaceView(handler, this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		
		menu.add(0,100,0,"分享");
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == 100){
			
			Intent intent = new Intent(MainActivity.this,ShareActivity.class);
			startActivity(intent);
			//System.out.println("hahahhah");
			//Toast.makeText(MainActivity.this, "fsfasf", Toast.LENGTH_LONG).show();
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
