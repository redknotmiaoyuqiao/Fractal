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

import com.redknot.fractalandroid.R;
import com.redknot.g.G;
import com.redknot.setting.Tree2Setting;
import com.redknot.util.ID;

public class ListActivity extends AppCompatActivity {

	private ListView listview;
	private String[] list = new String[] { "Koch1", "Koch2", "Flower",
			"Carpet", "Crown", "Levy", "Sierpinski", "Tree","Tree2", "Mountain",
			"Leaf", "Stone", "Dragon", "Fractint", "Landform" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		listview = (ListView) findViewById(R.id.list_view);
		listview.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, list));

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub

				int id = getId(list[pos]);
				G.id = id;

				if (G.id == ID.TREE2) {
					Intent intent = new Intent(ListActivity.this,
							Tree2Setting.class);

					startActivity(intent);
				} else {
					Intent intent = new Intent(ListActivity.this,
							SettingActivity.class);

					startActivity(intent);
				}

			}
		});
	}

	private int getId(String name) {
		if (name.equals("Koch1")) {
			return ID.KOCH1;
		}
		if (name.equals("Leaf")) {
			return ID.LEAF;
		}
		if (name.equals("Koch2")) {
			return ID.KOCH2;
		}
		if (name.equals("Flower")) {
			return ID.HUALAN;
		}
		if (name.equals("Crown")) {
			return ID.HUANGGUAN;
		}
		if (name.equals("Levy")) {
			return ID.LEVY;
		}
		if (name.equals("Sierpinski")) {
			return ID.SIERPINSKI;
		}
		if (name.equals("Tree")) {
			return ID.TREE;
		}
		if (name.equals("Mountain")) {
			return ID.MOUNTAIN;
		}
		if (name.equals("Stone")) {
			return ID.STONE;
		}
		if (name.equals("Dragon")) {
			return ID.DRAGON;
		}
		if (name.equals("Fractint")) {
			return ID.FRACTAL;
		}
		if (name.equals("Landform")) {
			return ID.LANDFROM;
		}
		if (name.equals("Newton")) {
			return ID.NEWTON;
		}
		if (name.equals("Carpet")) {
			return ID.CARPET;
		}
		if (name.equals("Tree2")) {
			return ID.TREE2;
		}
		if (name.equals("Leaf2")) {
			return ID.LEAF2;
		}
		return 0;
	}
}
