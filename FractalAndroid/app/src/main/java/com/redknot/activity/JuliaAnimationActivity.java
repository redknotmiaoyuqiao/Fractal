package com.redknot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.redknot.fractalandroid.R;
import com.redknot.julia.JuliaAnimationView;

public class JuliaAnimationActivity extends Activity {

    private JuliaAnimationView julia_animation_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏


        setContentView(R.layout.activity_julia_animation);


        julia_animation_view = (JuliaAnimationView)findViewById(R.id.julia_animation_view);
    }
}
