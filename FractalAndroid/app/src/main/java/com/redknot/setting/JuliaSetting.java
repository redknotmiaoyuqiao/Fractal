package com.redknot.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

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

    private EditText julia_c_image_edit;
    private EditText julia_c_real_edit;


    private Button submit;

    private int times = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_julia);

        julia_c_image_edit = (EditText) findViewById(R.id.julia_c_image_edit);
        //julia_c_image_edit.setText("0");
        julia_c_real_edit = (EditText) findViewById(R.id.julia_c_real_edit);
        //julia_c_real_edit.setText("0");

        julia_c_real_show = (TextView) findViewById(R.id.julia_c_real_show);
        julia_c_times_show = (TextView) findViewById(R.id.julia_c_times_show);
        julia_c_image_show = (TextView) findViewById(R.id.julia_c_image_show);
        julia_c_times = (SeekBar) findViewById(R.id.julia_c_times);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JuliaSetting.this, CustomJuliaActivity.class);

                double image = 0;
                double real = 0;
                try {
                    image = Double.valueOf(julia_c_image_edit.getText().toString());
                    real = Double.valueOf(julia_c_real_edit.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(JuliaSetting.this, "输入出错", Toast.LENGTH_LONG).show();
                    return;
                }

                intent.putExtra("real", real);
                intent.putExtra("image", image);
                intent.putExtra("times", times);
                startActivity(intent);
            }
        });

        julia_c_times.setMax(20);
        julia_c_times_show.setText("times : 0");
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
