package com.redknot.weibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.redknot.fractal.R;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.StatusesAPI;
import com.sina.weibo.sdk.openapi.models.ErrorInfo;
import com.sina.weibo.sdk.openapi.models.Status;
import com.sina.weibo.sdk.openapi.models.StatusList;

public class ShareActivity extends Activity {

	private AuthInfo mAuthInfo;
	private SsoHandler mSsoHandler;
	private Oauth2AccessToken mAccessToken;

	private Button btn_share;
	private ImageView img_show;

	private StatusesAPI mStatusesAPI;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share);

		btn_share = (Button) findViewById(R.id.btn_share);
		img_show = (ImageView) findViewById(R.id.img_show);
		
		img_show.setImageBitmap(Screen.Bmp);

		mAuthInfo = new AuthInfo(this, Constants.APP_KEY,
				Constants.REDIRECT_URL, Constants.SCOPE);

		mSsoHandler = new SsoHandler(ShareActivity.this, mAuthInfo);

		btn_share.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Oauth2AccessToken tokenAcc = AccessTokenKeeper
						.readAccessToken(ShareActivity.this);
				String token = tokenAcc.getToken();

				if (token.equals("")) {
					mSsoHandler.authorize(new AuthListener());
				} else {

					mAccessToken = AccessTokenKeeper
							.readAccessToken(ShareActivity.this);
					mStatusesAPI = new StatusesAPI(ShareActivity.this,
							Constants.APP_KEY, mAccessToken);

					Toast.makeText(ShareActivity.this, token, Toast.LENGTH_LONG)
							.show();
					
					
					mStatusesAPI.upload("发送一条带本地图片的微博", Screen.Bmp, null, null,
							mListener);
				}

			}
		});

	}

	private RequestListener mListener = new RequestListener() {
		@Override
		public void onComplete(String response) {
			if (!TextUtils.isEmpty(response)) {
				// LogUtil.i(TAG, response);
				if (response.startsWith("{\"statuses\"")) {
					// 调用 StatusList#parse 解析字符串成微博列表对象
					StatusList statuses = StatusList.parse(response);
					if (statuses != null && statuses.total_number > 0) {
						Toast.makeText(ShareActivity.this,
								"获取微博信息流成功, 条数: " + statuses.statusList.size(),
								Toast.LENGTH_LONG).show();
					}
				} else if (response.startsWith("{\"created_at\"")) {
					// 调用 Status#parse 解析字符串成微博对象
					Status status = Status.parse(response);
					Toast.makeText(ShareActivity.this,
							"发送一送微博成功, id = " + status.id, Toast.LENGTH_LONG)
							.show();
				} else {
					Toast.makeText(ShareActivity.this, response,
							Toast.LENGTH_LONG).show();
				}
			}
		}

		@Override
		public void onWeiboException(WeiboException e) {
			// LogUtil.e(TAG, e.getMessage());
			ErrorInfo info = ErrorInfo.parse(e.getMessage());
			Toast.makeText(ShareActivity.this, info.toString(),
					Toast.LENGTH_LONG).show();
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// SSO 授权回调
		// 重要：发起 SSO 登陆的 Activity 必须重写 onActivityResult
		if (mSsoHandler != null) {
			mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
		}
	}

	class AuthListener implements WeiboAuthListener {

		@Override
		public void onComplete(Bundle values) {
			// 从 Bundle 中解析 Token
			mAccessToken = Oauth2AccessToken.parseAccessToken(values);
			if (mAccessToken.isSessionValid()) {
				// 显示 Token
				// updateTokenView(false);

				// 保存 Token 到 SharedPreferences
				AccessTokenKeeper.writeAccessToken(ShareActivity.this,
						mAccessToken);
				Toast.makeText(ShareActivity.this,
						"success:" + mAccessToken.getToken(),
						Toast.LENGTH_SHORT).show();
			} else {
				// 以下几种情况，您会收到 Code：
				// 1. 当您未在平台上注册的应用程序的包名与签名时；
				// 2. 当您注册的应用程序包名与签名不正确时；
				// 3. 当您在平台上注册的包名和签名与您当前测试的应用的包名和签名不匹配时。
				String code = values.getString("code");
				String message = "fail";
				if (!TextUtils.isEmpty(code)) {
					message = message + "\nObtained the code: " + code;
				}
				Toast.makeText(ShareActivity.this, message, Toast.LENGTH_LONG)
						.show();
			}
		}

		@Override
		public void onCancel() {
			Toast.makeText(ShareActivity.this, "cancel", Toast.LENGTH_LONG)
					.show();
		}

		@Override
		public void onWeiboException(WeiboException e) {
			Toast.makeText(ShareActivity.this,
					"Auth exception : " + e.getMessage(), Toast.LENGTH_LONG)
					.show();
		}
	}
}
