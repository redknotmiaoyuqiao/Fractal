package com.redknot.fractalpad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.redknot.view.DrawPadSurfaceView;


public class FullscreenActivity extends AppCompatActivity {

    private DrawPadSurfaceView drawpad_surfaceview;
    private FloatingActionButton clear_pad;
    private FloatingActionButton go_fractal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_fullscreen);

        drawpad_surfaceview = (DrawPadSurfaceView) findViewById(R.id.drawpad_surfaceview);

        clear_pad = (FloatingActionButton) findViewById(R.id.clear_pad);
        go_fractal = (FloatingActionButton) findViewById(R.id.go_fractal);

        clear_pad.setOnClickListener(new MyFloatButtonOnClickListener());
        go_fractal.setOnClickListener(new MyFloatButtonOnClickListener());
    }

    private class MyFloatButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == clear_pad) {
                drawpad_surfaceview.clearPath();
            }
            if (v == go_fractal) {
                Intent intent = new Intent(FullscreenActivity.this,SettingActivity.class);
                intent.putExtra("point",drawpad_surfaceview.getPath().toString());
                startActivity(intent);
            }
        }
    }

}
