package com.redknot.httputil;

import android.app.ProgressDialog;
import android.content.Context;

public class MyProgressDialog {

	private ProgressDialog progressDialog;
	private String show;
	private Context ctx;

	public MyProgressDialog(Context ctx, String show) {
		this.ctx = ctx;
		this.show = show;
	}

	public void showLoginProgressDialog() {

		if (progressDialog == null) {
			progressDialog = new ProgressDialog(this.ctx);
			progressDialog.setMessage(this.show);
			progressDialog.setCanceledOnTouchOutside(false);
			progressDialog.setCancelable(false);
		}
		progressDialog.show();
	}

	public void closeLoginProgressDialog() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
		}
	}

}

