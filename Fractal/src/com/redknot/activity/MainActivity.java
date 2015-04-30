package com.redknot.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Intent intent = this.getIntent();
		int id = intent.getIntExtra("id", 0);
		int color = intent.getIntExtra("color", 0);
		int n = intent.getIntExtra("n", 1);

		MyHandler handler = new MyHandler();

		setContentView(new MySurfaceView(handler, this, id, n, color));
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
