package com.redknot.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.redknot.activity.JuliaAnimationActivity;
import com.redknot.activity.SettingActivity;
import com.redknot.domain.FractalItem;
import com.redknot.fractalandroid.FractalActivity;
import com.redknot.fractalandroid.R;
import com.redknot.g.G;
import com.redknot.setting.JuliaSetting;
import com.redknot.setting.Tree2Setting;
import com.redknot.util.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miaoyuqiao on 16/5/2.
 */
@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {

    private int id = -1;
    private ListView listview;
    private List<FractalItem> list = new ArrayList<>();

    public MainFragment(int id) {
        this.id = id;
        addItem();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listview = (ListView) view.findViewById(R.id.fragment_listview);
        listview.setAdapter(new ArrayAdapter<FractalItem>(this.getContext(),android.R.layout.simple_expandable_list_item_1, list));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long arg3) {
                // TODO Auto-generated method stub

                if (list.get(pos).getToWhere() == 1) {
                    //一般
                    Intent intent = new Intent(MainFragment.this.getContext(),
                            SettingActivity.class);
                    G.id = list.get(pos).getId();
                    startActivity(intent);
                }

                if (list.get(pos).getToWhere() == 2) {
                    //Tree2
                    Intent intent = new Intent(MainFragment.this.getContext(),
                            Tree2Setting.class);
                    G.id = list.get(pos).getId();
                    startActivity(intent);
                }

                if (list.get(pos).getToWhere() == 3) {
                    //集合
                    Intent intent = new Intent(MainFragment.this.getContext(),
                            FractalActivity.class);
                    intent.putExtra("G_ID", list.get(pos).getId());

                    startActivity(intent);
                }

                if (list.get(pos).getToWhere() == 4) {
                    //集合
                    Intent intent = new Intent(MainFragment.this.getContext(),
                            JuliaSetting.class);
                    //intent.putExtra("G_ID", list.get(pos).getId());

                    startActivity(intent);
                }

                if (list.get(pos).getToWhere() == 5) {
                    Intent intent = new Intent(MainFragment.this.getContext(), JuliaAnimationActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

    private void addItem() {
        if(this.id == 1){
            list.add(new FractalItem("Koch1", ID.KOCH1, 1));
            list.add(new FractalItem("Koch2", ID.KOCH2, 1));
            list.add(new FractalItem("Flower", ID.HUALAN, 1));
            list.add(new FractalItem("Carpet", ID.CARPET, 1));
            list.add(new FractalItem("Crown", ID.HUANGGUAN, 1));
            list.add(new FractalItem("Levy", ID.LEVY, 1));
            list.add(new FractalItem("Sierpinski", ID.SIERPINSKI, 1));
            list.add(new FractalItem("Tree", ID.TREE, 1));

            list.add(new FractalItem("Tree2", ID.TREE2, 2));

            list.add(new FractalItem("Mountain", ID.MOUNTAIN, 1));
            list.add(new FractalItem("Leaf", ID.LEAF, 1));
            list.add(new FractalItem("Stone", ID.STONE, 1));
            list.add(new FractalItem("Dragon", ID.DRAGON, 1));
            list.add(new FractalItem("Fractint", ID.FRACTAL, 1));
            list.add(new FractalItem("Landform", ID.LANDFROM, 1));
        }
        if(this.id == 2){
            list.add(new FractalItem("Mandelbrot", ID.Mandelbrot, 3));
            list.add(new FractalItem("Mandelbrot2", ID.Mandelbrot2, 3));
            list.add(new FractalItem("Mandelbrot3", ID.Mandelbrot3, 3));
            //list.add(new FractalItem("Buddhabrot",ID.Buddhabrot,3));
            list.add(new FractalItem("Julia", ID.Julia, 3));


            list.add(new FractalItem("CustomJulia", ID.CustomJulia, 4));
            list.add(new FractalItem("Julia Animation", ID.JuliaAnimation, 5));
        }
    }
}
