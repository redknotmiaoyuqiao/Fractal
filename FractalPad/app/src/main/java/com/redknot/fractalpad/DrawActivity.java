package com.redknot.fractalpad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.redknot.view.DrawSurfaceView;

/**
 * Created by miaoyuqiao on 16/4/12.
 */
public class DrawActivity extends AppCompatActivity {

    private DrawSurfaceView draw_surfaceview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_draw);

        String point = getIntent().getStringExtra("point");

        draw_surfaceview = (DrawSurfaceView) findViewById(R.id.draw_surfaceview);
    }
}
