package com.redknot.activity;

import com.redknot.thinkkepu.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class SubjectActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject);
		
		Resources ares = getResources();
        Drawable myDrawable = ares.getDrawable(R.drawable.actionbar);
		getActionBar().setBackgroundDrawable(myDrawable);
	}
}
