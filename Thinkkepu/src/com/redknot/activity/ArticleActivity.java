package com.redknot.activity;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.redknot.httputil.MyHandler;
import com.redknot.httputil.UrlUtil;
import com.redknot.thinkkepu.R;
import com.redknot.thread.SendCommentThread;
import com.redknot.util.LoginSession;
import com.redknot.util.MyToast;

public class ArticleActivity extends Activity {

	private WebView main_webview;
	private Button btn_send;
	private ProgressBar progress_bar;
	private EditText et_comment;
	
	private CommentHandler handler;
	
	private int i = 0;
	
	private MyToast toast;

	@SuppressLint({ "SetJavaScriptEnabled", "NewApi" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article);
		
		getActionBar().setTitle(this.getIntent().getStringExtra("title"));
		Resources res = getResources();
        Drawable myDrawable = res.getDrawable(R.drawable.actionbar);
		getActionBar().setBackgroundDrawable(myDrawable);

		toast = new MyToast(ArticleActivity.this);
		
		this.i = this.getIntent().getIntExtra("id", -1);

		btn_send = (Button) findViewById(R.id.btn_send);
		et_comment = (EditText) findViewById(R.id.et_comment);
		main_webview = (WebView) findViewById(R.id.main_webview);
		progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
		main_webview.getSettings().setJavaScriptEnabled(true);
		main_webview.setWebViewClient(new MyWebViewClient());
		main_webview.loadUrl(UrlUtil.GET_WEN + "?id=" + i);
		
		handler = new CommentHandler();

		btn_send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				LoginSession login = new LoginSession(ArticleActivity.this);
				String session = login.getSession();
				if (session.equals("<nano>")) {
					Intent intent = new Intent(ArticleActivity.this,
							LoginActivity.class);
					startActivity(intent);
				} else {
					sendComment();
				}
			}
		});

	}
	
	private void sendComment(){
		String comment = et_comment.getText().toString();
		if(comment.equals("")){
			toast.show(R.string.err_comment_empty);
			return;
		}
		progress_bar.setVisibility(View.VISIBLE);
	    Map<String, String> rawparams = new HashMap<String, String>();
	    rawparams.put("art_id", this.i + "");
	    
	    LoginSession user = new LoginSession(ArticleActivity.this);
	    
	    rawparams.put("user_session", user.getSession());
	    rawparams.put("art_comment", comment);
		SendCommentThread t = new SendCommentThread(rawparams , handler);
		new Thread(t).start();
	}
	
	@SuppressLint("HandlerLeak") 
	private class CommentHandler extends MyHandler{

		@Override
		public void fail() {
			// TODO Auto-generated method stub
			progress_bar.setVisibility(View.INVISIBLE);
		}

		@Override
		public void success(String res) {
			// TODO Auto-generated method stub
			progress_bar.setVisibility(View.INVISIBLE);
			if(res.equals("success")){
				progress_bar.setVisibility(View.VISIBLE);
				main_webview.loadUrl(UrlUtil.GET_WEN + "?id=" + i);
				et_comment.setText("");
			}
			else if(res.equals("login")){
				Intent intent = new Intent(ArticleActivity.this,LoginActivity.class);
				startActivity(intent);
			}
		}
	}

	private class MyWebViewClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return true;
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			if (main_webview.getContentHeight() != 0) {
				progress_bar.setVisibility(View.INVISIBLE);
			}
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inmenu = getMenuInflater();
		inmenu .inflate(R.menu.menu_article, menu);
		
		return true;
	}
	
}
