package com.redknot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.redknot.adapter.FragmentAdapter;
import com.redknot.domain.FractalItem;
import com.redknot.domain.Tab;
import com.redknot.fractalandroid.FractalActivity;
import com.redknot.fractalandroid.R;
import com.redknot.fragment.MainFragment;
import com.redknot.g.G;
import com.redknot.setting.JuliaSetting;
import com.redknot.setting.Tree2Setting;
import com.redknot.util.ID;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private TabLayout main_tablayout;
    private ViewPager main_viewpage;

    private FragmentAdapter fragmentAdapter;


    private List<FractalItem> list = new ArrayList<>();
    private List<Tab> tabList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fractal");
        setSupportActionBar(toolbar);*/

        main_tablayout = (TabLayout) findViewById(R.id.main_tablayout);
        main_viewpage = (ViewPager) findViewById(R.id.main_viewpage);

        tabList.add(new Tab("Geometry", new MainFragment(1)));
        tabList.add(new Tab("Set", new MainFragment(2)));

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), tabList);

        main_viewpage.setAdapter(fragmentAdapter);
        main_tablayout.setupWithViewPager(main_viewpage);
        main_tablayout.setTabsFromPagerAdapter(fragmentAdapter);
    }
}
