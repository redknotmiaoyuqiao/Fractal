package com.redknot.fractalpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by miaoyuqiao on 16/4/12.
 */
public class SettingActivity extends AppCompatActivity {

    private TextView show;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_setting);

        show = (TextView) findViewById(R.id.show);

        show.setText(getIntent().getStringExtra("point"));

        Intent intent = new Intent(SettingActivity.this,DrawActivity.class);
        intent.putExtra("point",getIntent().getStringExtra("point"));
        startActivity(intent);
        finish();
    }
}
