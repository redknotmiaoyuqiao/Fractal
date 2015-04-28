package com.redknot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.redknot.fractal.R;
import com.redknot.util.ID;

public class ListActivity extends Activity{
	
	private ListView listview;
	private String[] list = new String[]{"koch1","koch2","flower","crown","levy","sierpinski","tree","mountain","leaf","stone","dragon","fractint","landform","newton"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		listview = (ListView) findViewById(R.id.list_view);
		listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list));
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(ListActivity.this,SettingActivity.class);
				int id = getId(list[pos]);
				intent.putExtra("id", id);
				
				startActivity(intent);
				
			}
		});
	}
	
	private int getId(String name){
		if(name.equals("koch1")){
			return ID.KOCH1;
		}
		if(name.equals("leaf")){
			return ID.LEAF;
		}
		if(name.equals("koch2")){
			return ID.KOCH2;
		}
		if(name.equals("flower")){
			return ID.HUALAN;
		}
		if(name.equals("crown")){
			return ID.HUANGGUAN;
		}
		if(name.equals("levy")){
			return ID.LEVY;
		}
		if(name.equals("sierpinski")){
			return ID.SIERPINSKI;
		}
		if(name.equals("tree")){
			return ID.TREE;
		}
		if(name.equals("mountain")){
			return ID.MOUNTAIN;
		}
		if(name.equals("stone")){
			return ID.STONE;
		}
		if(name.equals("dragon")){
			return ID.DRAGON;
		}
		if(name.equals("fractint")){
			return ID.FRACTAL;
		}
		if(name.equals("landform")){
			return ID.LANDFROM;
		}
		if(name.equals("newton")){
			return ID.NEWTON;
		}
		return 0;
	}
}
