package com.redknot.fractalandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.redknot.view.FractalSurfaceView;
import com.redknot.view.JuliaSurfaceView;

/**
 * Created by miaoyuqiao on 16/4/17.
 */
public class CustomJuliaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏

        double real = getIntent().getDoubleExtra("real", 0.0);
        double image = getIntent().getDoubleExtra("image", 0.0);
        int times = getIntent().getIntExtra("times", 0);

        setContentView(new JuliaSurfaceView(this,real,image,times));
    }
}
