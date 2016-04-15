package com.redknot.fractalandroid;

import android.app.Activity;
import android.os.Bundle;

import com.redknot.view.FractalSurfaceView;

/**
 * Created by miaoyuqiao on 16/4/16.
 */

public class FractalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int G_ID = getIntent().getIntExtra("G_ID", 0);

        setContentView(new FractalSurfaceView(this,G_ID));
    }
}
