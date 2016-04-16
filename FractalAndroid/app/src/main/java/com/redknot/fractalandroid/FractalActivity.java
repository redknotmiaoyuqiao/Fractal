package com.redknot.fractalandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.redknot.view.FractalSurfaceView;

/**
 * Created by miaoyuqiao on 16/4/16.
 */

public class FractalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏

        int G_ID = getIntent().getIntExtra("G_ID", 0);

        setContentView(new FractalSurfaceView(this,G_ID));
    }
}
