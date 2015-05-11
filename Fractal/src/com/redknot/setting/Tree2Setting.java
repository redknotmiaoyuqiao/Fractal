package com.redknot.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.redknot.activity.MainActivity;
import com.redknot.activity.SettingActivity;
import com.redknot.fractal.R;
import com.redknot.g.G;

public class Tree2Setting extends Activity {

	private SeekBar red;
	private SeekBar green;
	private SeekBar blue;

	private SeekBar times;

	private SeekBar leftAngle;
	private SeekBar rightAngle;

	private SeekBar scale;

	private TextView tv_red;
	private TextView tv_green;
	private TextView tv_blue;

	private TextView tv_times;

	private TextView tv_leftAngle;
	private TextView tv_rightAngle;

	private TextView tv_scale;

	private ImageView color_show;

	private Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_tree2);

		init();
	}

	private void init() {
		submit = (Button) findViewById(R.id.tree2_submit);
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Tree2Setting.this,
						MainActivity.class);

				G.n = times.getProgress();
				G.color = Color.rgb(red.getProgress(), green.getProgress(),
						blue.getProgress());
				G.Scale = (float)(scale.getProgress() * 0.01);
				G.Angle_L = leftAngle.getProgress();
				G.Angle_R = rightAngle.getProgress();

				startActivity(intent);
			}
		});

		color_show = (ImageView) findViewById(R.id.tree2_color_show);
		red = (SeekBar) findViewById(R.id.tree2_red);
		green = (SeekBar) findViewById(R.id.tree2_green);
		blue = (SeekBar) findViewById(R.id.tree2_blue);

		times = (SeekBar) findViewById(R.id.tree2_time);

		leftAngle = (SeekBar) findViewById(R.id.tree2_left_angle);
		rightAngle = (SeekBar) findViewById(R.id.tree2_right_angle);

		scale = (SeekBar) findViewById(R.id.tree2_scale);

		tv_red = (TextView) findViewById(R.id.tree2_tv_red);
		tv_red.setText("R:0");
		tv_green = (TextView) findViewById(R.id.tree2_tv_green);
		tv_green.setText("G:0");
		tv_blue = (TextView) findViewById(R.id.tree2_tv_blue);
		tv_blue.setText("B:0");

		tv_times = (TextView) findViewById(R.id.tree2_tv_time);
		tv_times.setText("time:0");

		tv_leftAngle = (TextView) findViewById(R.id.tree2_tv_left_angle);
		tv_leftAngle.setText("left:0");
		tv_rightAngle = (TextView) findViewById(R.id.tree2_tv_right_angle);
		tv_rightAngle.setText("right:0");

		tv_scale = (TextView) findViewById(R.id.tree2_tv_scale);
		tv_scale.setText("scale:0.00");
		red.setMax(255);
		green.setMax(255);
		blue.setMax(255);
		times.setMax(20);
		leftAngle.setMax(90);
		rightAngle.setMax(90);
		scale.setMax(100);
		MyOnSeekBarChangeListener seekBarListener = new MyOnSeekBarChangeListener();

		red.setOnSeekBarChangeListener(seekBarListener);
		green.setOnSeekBarChangeListener(seekBarListener);
		blue.setOnSeekBarChangeListener(seekBarListener);
		times.setOnSeekBarChangeListener(seekBarListener);
		leftAngle.setOnSeekBarChangeListener(seekBarListener);
		rightAngle.setOnSeekBarChangeListener(seekBarListener);
		scale.setOnSeekBarChangeListener(seekBarListener);

		Bitmap bitmap = Bitmap.createBitmap(50, 50, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawColor(Color.rgb(red.getProgress(), green.getProgress(),
				blue.getProgress()));
		color_show.setImageBitmap(bitmap);

	}

	private class MyOnSeekBarChangeListener implements OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekbar, int i, boolean arg2) {
			// TODO Auto-generated method stub
			if (seekbar == red) {
				tv_red.setText("R:" + i);
			} else if (seekbar == blue) {
				tv_blue.setText("B:" + i);
			} else if (seekbar == green) {
				tv_green.setText("G:" + i);
			} else if (seekbar == times) {
				tv_times.setText("time:" + i);
			} else if (seekbar == leftAngle) {
				tv_leftAngle.setText("left:" + i);
			} else if (seekbar == rightAngle) {
				tv_rightAngle.setText("right:" + i);
			} else if (seekbar == scale) {
				tv_scale.setText("scale:" + (float) (i * 0.01));
			}

			Bitmap bitmap = Bitmap.createBitmap(50, 50, Config.ARGB_8888);
			Canvas canvas = new Canvas(bitmap);
			canvas.drawColor(Color.rgb(red.getProgress(), green.getProgress(),
					blue.getProgress()));
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
}
