package com.redknot.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.widget.ListView;

import com.redknot.adapter.SubjectAdapter;
import com.redknot.model.Subject;
import com.redknot.thinkkepu.R;

public class SubjectActivity extends Activity{
	
	private SwipeRefreshLayout subject_list_refresh;
	private ListView subject_listview;
	private SubjectAdapter adapter;
	private List<Subject> data = new ArrayList<Subject>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Resources ares = getResources();
        Drawable myDrawable = ares.getDrawable(R.drawable.actionbar);
		getActionBar().setBackgroundDrawable(myDrawable);
		getActionBar().setTitle("×¨Ìâ");
		
		setContentView(R.layout.activity_subject);
		
		data.add(new Subject());
		data.add(new Subject());
		data.add(new Subject());
		data.add(new Subject());
		data.add(new Subject());
		
		init();
			
	}
	
	private void init(){
		adapter = new SubjectAdapter(data, this);
		subject_list_refresh = (SwipeRefreshLayout) findViewById(R.id.subject_list_refresh);
		subject_listview = (ListView) findViewById(R.id.subject_listview);
		
		subject_listview.setAdapter(adapter);
		
		subject_list_refresh.setColorScheme(R.color.blue1, R.color.blue2,
				R.color.blue3, R.color.blue4);
		
		subject_list_refresh.setOnRefreshListener(new OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
