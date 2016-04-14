package com.redknot.fractalpad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.redknot.domain.Point;
import com.redknot.view.DrawSurfaceView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by miaoyuqiao on 16/4/12.
 */
public class DrawActivity extends AppCompatActivity {

    private DrawSurfaceView draw_surfaceview;
    public static ArrayList<Point> points = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_draw);

        String point = getIntent().getStringExtra("point");

        try {
            JSONArray ja = new JSONArray(point);
            points.clear();
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                Point p = new Point((float)jo.getDouble("x"),(float)jo.getDouble("y"));
                points.add(p);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        draw_surfaceview = (DrawSurfaceView) findViewById(R.id.draw_surfaceview);
        draw_surfaceview.setPoints(points);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
