package com.redknot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.redknot.domain.FractalItem;
import com.redknot.fractalandroid.FractalActivity;
import com.redknot.fractalandroid.R;
import com.redknot.g.G;
import com.redknot.setting.Tree2Setting;
import com.redknot.util.ID;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listview;

    private List<FractalItem> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        addItem();

        listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(new ArrayAdapter<FractalItem>(this,
                android.R.layout.simple_expandable_list_item_1, list));

        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long arg3) {
                // TODO Auto-generated method stub

                if (list.get(pos).getToWhere() == 1) {
                    //一般
                    Intent intent = new Intent(ListActivity.this,
                            SettingActivity.class);
                    G.id = list.get(pos).getId();
                    startActivity(intent);
                }

                if(list.get(pos).getToWhere() == 2){
                    //Tree2
                    Intent intent = new Intent(ListActivity.this,
                            Tree2Setting.class);
                    G.id = list.get(pos).getId();
                    startActivity(intent);
                }

                if(list.get(pos).getToWhere() == 3){
                    //集合
                    Intent intent = new Intent(ListActivity.this,
                            FractalActivity.class);
                    intent.putExtra("G_ID", list.get(pos).getId());

                    startActivity(intent);
                }
            }
        });
    }

    private void addItem(){
        list.add(new FractalItem("Koch1",ID.KOCH1,1));
        list.add(new FractalItem("Koch2",ID.KOCH2,1));
        list.add(new FractalItem("Flower",ID.HUALAN,1));
        list.add(new FractalItem("Carpet",ID.CARPET,1));
        list.add(new FractalItem("Crown",ID.HUANGGUAN,1));
        list.add(new FractalItem("Levy",ID.LEVY,1));
        list.add(new FractalItem("Sierpinski",ID.SIERPINSKI,1));
        list.add(new FractalItem("Tree",ID.TREE,1));

        list.add(new FractalItem("Tree2",ID.TREE2,2));

        list.add(new FractalItem("Mountain",ID.MOUNTAIN,1));
        list.add(new FractalItem("Leaf",ID.LEAF,1));
        list.add(new FractalItem("Stone",ID.STONE,1));
        list.add(new FractalItem("Dragon",ID.DRAGON,1));
        list.add(new FractalItem("Fractint",ID.FRACTAL,1));
        list.add(new FractalItem("Landform",ID.LANDFROM,1));

        list.add(new FractalItem("Mandelbrot",ID.Mandelbrot,3));
        list.add(new FractalItem("Mandelbrot2",ID.Mandelbrot2,3));
        list.add(new FractalItem("Mandelbrot3",ID.Mandelbrot3,3));
        //list.add(new FractalItem("Buddhabrot",ID.Buddhabrot,3));
        list.add(new FractalItem("Julia",ID.Julia,3));
    }
}
