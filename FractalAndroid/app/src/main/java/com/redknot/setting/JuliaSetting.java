package com.redknot.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.redknot.fractalandroid.CustomJuliaActivity;
import com.redknot.fractalandroid.R;

/**
 * Created by miaoyuqiao on 16/4/18.
 */
public class JuliaSetting extends AppCompatActivity {

    private TextView julia_c_real_show;
    private TextView julia_c_image_show;
    private TextView julia_c_times_show;
    private SeekBar julia_c_times;
    private SeekBar julia_c_real;
    private SeekBar julia_c_image;

    private Button submit;

    private double real = 0;
    private double image = 0;
    private int times = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_julia);

        julia_c_real_show = (TextView) findViewById(R.id.julia_c_real_show);
        julia_c_times_show = (TextView) findViewById(R.id.julia_c_times_show);
        julia_c_image_show = (TextView) findViewById(R.id.julia_c_image_show);
        julia_c_real = (SeekBar) findViewById(R.id.julia_c_real);
        julia_c_image = (SeekBar) findViewById(R.id.julia_c_image);
        julia_c_times = (SeekBar) findViewById(R.id.julia_c_times);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JuliaSetting.this, CustomJuliaActivity.class);
                intent.putExtra("real", real);
                intent.putExtra("image", image);
                intent.putExtra("times", times);
                startActivity(intent);
            }
        });

        julia_c_real.setMax(1000);
        julia_c_real.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                real = (progress - 500) * 0.001;
                julia_c_real_show.setText("real : " + (progress - 500) * 0.001);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        julia_c_image.setMax(1000);
        julia_c_image.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                image = (progress - 500) * 0.001;
                julia_c_image_show.setText("image : " + (progress - 500) * 0.001);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        julia_c_times.setMax(20);
        julia_c_times.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                times = progress;
                julia_c_times_show.setText("times : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
