package com.redknot.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.redknot.activity.ArticleActivity;
import com.redknot.adapter.MainListViewAdapter;
import com.redknot.httputil.MyHandler;
import com.redknot.model.Article;
import com.redknot.thinkkepu.R;
import com.redknot.thread.GetArticleListThread;
import com.redknot.util.MyToast;
import com.redknot.util.PhoneListUtil;

@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {

	private ListView main_listview;
	private SwipeRefreshLayout main_list_refresh;
	private MainListViewAdapter adapter;

	private List<Article> data = new ArrayList<Article>();
	private MainHandler handler;
	private ScrollRef ref_handler;

	private LayoutAnimationController animationCont;
	private Animation animation;

	private int i;
	
	private MyToast toast;

	@SuppressLint("ValidFragment")
	public MainFragment(int i) {
		this.i = i;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		toast = new MyToast(getActivity());
		
		View view = inflater.inflate(R.layout.fragment_main, container, false);

		animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(250);

		animationCont = new LayoutAnimationController(animation, 0.5f);

		main_list_refresh = (SwipeRefreshLayout) view
				.findViewById(R.id.main_list_refresh);
		main_list_refresh.setColorScheme(R.color.blue1, R.color.blue2,
				R.color.blue3, R.color.blue4);

		handler = new MainHandler();
		ref_handler = new ScrollRef();
		
		GetArticleListThread t = new GetArticleListThread(handler, this.i);

		if (data.size() == 0) {
			PhoneListUtil phone = new PhoneListUtil(getActivity());
			ArrayList<Article> list = phone.getList(MainFragment.this.i);
			for (Article a : list) {
				data.add(a);
			}

			new Thread(t).start();
			main_list_refresh.setRefreshing(true);
		}

		main_listview = (ListView) view.findViewById(R.id.main_listview);
		adapter = new MainListViewAdapter(data, getActivity());

		main_listview.setAdapter(adapter);

		main_listview.setOnItemClickListener(new MyListOnItemClickListener());
		main_listview.setOnScrollListener(new MyOnScrollListener());

		main_list_refresh.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				GetArticleListThread t = new GetArticleListThread(handler, i);
				new Thread(t).start();
			}
		});

		return view;
	}
	
	private boolean isRef = false;

	private class MyOnScrollListener implements OnScrollListener {
		@Override
		public void onScrollStateChanged(AbsListView view, int state) {
			// TODO Auto-generated method stub
			if (state == OnScrollListener.SCROLL_STATE_IDLE) {
				if (view.getLastVisiblePosition() == view.getCount() - 1) {
					if(isRef == false){
						System.out.println("XXXXXXXXXXXXXXXXXXXXXxx");
						int size = MainFragment.this.data.size();
						GetArticleListThread t = new GetArticleListThread(ref_handler, MainFragment.this.i,size);
						new Thread(t).start();
						
						isRef = true;
						Intent intent = new Intent();
						intent.setAction("com.redknot.receiver.listview");
						intent.putExtra("stat", 2);
						getActivity().sendBroadcast(intent);
					}
				}
			}
		}

		@Override
		public void onScroll(AbsListView view, int first, int count,
				int totalltemCount) {
			// TODO Auto-generated method stub

		}

	}

	private class MyListOnItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
				long arg3) {
			// TODO Auto-generated method stub
			if (pos == MainFragment.this.data.size()) {
				int size = MainFragment.this.data.size();
				GetArticleListThread t = new GetArticleListThread(ref_handler, MainFragment.this.i,size);
				new Thread(t).start();
				isRef = true;
				Intent intent = new Intent();
				intent.setAction("com.redknot.receiver.listview");
				intent.putExtra("stat", 2);
				getActivity().sendBroadcast(intent);
			} else {
				Intent intent = new Intent(getActivity(), ArticleActivity.class);
				int i = data.get(pos).getId();
				intent.putExtra("id", i);
				intent.putExtra("title", data.get(pos).getTitle());
				startActivity(intent);
			}
		}
	}

	@SuppressLint("HandlerLeak") 
	private class ScrollRef extends MyHandler {

		@Override
		public void fail() {
			// TODO Auto-generated method stub
			isRef = false;
			Intent intent = new Intent();
			intent.setAction("com.redknot.receiver.listview");
			intent.putExtra("stat", 0);
			getActivity().sendBroadcast(intent);
		}

		@Override
		public void success(String res) {
			// TODO Auto-generated method stub
			try {
				System.out.println(res);

				JSONArray ja = new JSONArray(res);
				for (int i = 0; i < ja.length(); i++) {
					JSONObject jo = ja.getJSONObject(i);
					Article a = new Article(jo);
					MainFragment.this.data.add(a);
				}

				PhoneListUtil phone = new PhoneListUtil(getActivity());
				phone.saveList(MainFragment.this.data, MainFragment.this.i);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//toast.show(R.string.err_network);
			}

			// main_listview.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			isRef = false;
			
			Intent intent = new Intent();
			intent.setAction("com.redknot.receiver.listview");
			intent.putExtra("stat", 2);
			getActivity().sendBroadcast(intent);
		}

	}

	@SuppressLint("HandlerLeak")
	private class MainHandler extends MyHandler {

		@Override
		public void fail() {
			// TODO Auto-generated method stub
			main_list_refresh.setRefreshing(false);
			toast.show(R.string.err_network);
		}

		@Override
		public void success(String res) {
			// TODO Auto-generated method stub
			try {
				System.out.println(res);

				JSONArray ja = new JSONArray(res);
				MainFragment.this.data.clear();
				for (int i = 0; i < ja.length(); i++) {
					JSONObject jo = ja.getJSONObject(i);
					Article a = new Article(jo);
					MainFragment.this.data.add(a);
				}

				PhoneListUtil phone = new PhoneListUtil(getActivity());
				phone.saveList(MainFragment.this.data, MainFragment.this.i);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				toast.show(R.string.err_network);
			}

			// main_listview.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			main_list_refresh.setRefreshing(false);
			main_listview.setLayoutAnimation(animationCont);
		}

	}

}
