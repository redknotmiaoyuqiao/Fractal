package com.redknot.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.redknot.httputil.MyHandler;
import com.redknot.httputil.MyProgressDialog;
import com.redknot.thinkkepu.R;
import com.redknot.thread.LoginThread;
import com.redknot.util.MyToast;
import com.redknot.util.UserInformation;

public class LoginActivity extends Activity {

	private EditText et_username;
	private EditText et_password;
	private Button btn_login;

	private MyProgressDialog progress;

	private LoginHandler handler;

	private MyToast toast;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Resources ares = getResources();
        Drawable myDrawable = ares.getDrawable(R.drawable.actionbar);
		getActionBar().setBackgroundDrawable(myDrawable);

		init();
	}

	private void init() {
		toast = new MyToast(LoginActivity.this);
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		btn_login = (Button) findViewById(R.id.btn_login);
		progress = new MyProgressDialog(LoginActivity.this, getText(R.string.wait_login).toString());

		handler = new LoginHandler();

		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String username = et_username.getText().toString();
				String password = et_password.getText().toString();
				if (!username.equals("") && !password.equals("")) {
					progress.showLoginProgressDialog();
					LoginThread t = new LoginThread(handler, username, password);
					new Thread(t).start();
				} else {
					toast.show(R.string.err_login_empty);
				}
			}
		});
	}

	@SuppressLint("HandlerLeak")
	private class LoginHandler extends MyHandler {

		@Override
		public void fail() {
			// TODO Auto-generated method stub
			toast.show(R.string.err_network);
			progress.closeLoginProgressDialog();
		}

		@Override
		public void success(String res) {
			// TODO Auto-generated method stub
			if (res.equals("empty")) {
				toast.show(R.string.err_login_empty);
			} else if (res.equals("falut")) {
				toast.show(R.string.err_login_mistake);
			} else {
				toast.show(R.string.success_login_success);
				UserInformation user = new UserInformation(LoginActivity.this);
				user.setUser(res);

				finish();
			}

			progress.closeLoginProgressDialog();
		}
	}
}
