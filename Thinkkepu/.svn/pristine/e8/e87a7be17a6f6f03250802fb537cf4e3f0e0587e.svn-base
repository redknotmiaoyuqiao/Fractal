package com.redknot.thread;

import android.content.Context;

import com.redknot.httputil.HttpUtil;
import com.redknot.httputil.UrlUtil;
import com.redknot.util.ClassList;

//获取分类列表
public class GetClassListThread implements Runnable{
	
	private Context context;
	
	public GetClassListThread(Context context){
		this.context = context;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String res = HttpUtil.getRequest(UrlUtil.GET_CLASS_LIST);
			System.out.println(res);
			ClassList list = new ClassList(this.context);
			list.setList(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
