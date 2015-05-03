package com.redknot.adapter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.redknot.httputil.UrlUtil;
import com.redknot.model.Article;
import com.redknot.thinkkepu.R;
import com.redknot.thread.GetImageThread;
import com.redknot.util.ImageUtil;

public class MainListViewAdapter extends BaseAdapter {

	private List<Article> data;
	private Context context;
	ListViewReceiver receiver;

	public MainListViewAdapter(List<Article> data, Context context) {
		this.data = data;
		this.context = context;
		
		
		this.receiver = new ListViewReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction("com.redknot.receiver.listview");
		this.context.registerReceiver(receiver, filter);
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.data.size() + 1;
	}

	@Override
	public Object getItem(int i) {
		// TODO Auto-generated method stub
		if (i < this.data.size()) {
			return this.data.get(i);
		}
		return null;
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i + 1;
	}

	@SuppressLint({ "InflateParams", "SimpleDateFormat" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = LayoutInflater.from(context);
		View view = null;

		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(300);

		if (position == this.data.size()) {
			view = inflater.inflate(R.layout.listview_last, null);
			
			TextView t = (TextView) view.findViewById(R.id.load);
			ProgressBar p = (ProgressBar) view.findViewById(R.id.pro_load);
			
			
			if(Mstat == 2){
				t.setText("正在更新");
				t.setVisibility(View.VISIBLE);
				p.setVisibility(View.VISIBLE);
			}
			else if(Mstat == 0){
				t.setText("更新失败，点击重试");
				t.setVisibility(View.VISIBLE);
				p.setVisibility(View.INVISIBLE);
			}
			
			if(this.data.size() == 0){
				p.setVisibility(View.INVISIBLE);
				t.setVisibility(View.INVISIBLE);
			}
			
		} else if (position == 0) {
			view = inflater.inflate(R.layout.listview_first, null);
			ImageView img = (ImageView) view.findViewById(R.id.first_img);
			TextView title = (TextView) view.findViewById(R.id.first_title);
			ProgressBar bar = (ProgressBar) view
					.findViewById(R.id.first_progressBar);

			title.setText(this.data.get(position).getTitle());

			Bitmap bitmap = data.get(position).getImg();

			if (bitmap == null) {
				bitmap = getImg(data.get(position).getImg_url());

				if (bitmap == null) {
					ImgHandler handler = new ImgHandler(position, img, bar,
							this.data.get(position).getImg_url());
					GetImageThread t = new GetImageThread(handler,
							UrlUtil.BASE_URL + "/files/"  
									+ this.data.get(position).getImg_url());
					new Thread(t).start();
				}

				else {
					img.setImageBitmap(bitmap);
					bar.setVisibility(View.INVISIBLE);
					
				}

			} else {
				img.setImageBitmap(bitmap);
				bar.setVisibility(View.INVISIBLE);
				
			}

		} else if (position % 5 == 0) {
			view = inflater.inflate(R.layout.listview_five, null);

			ProgressBar bar = (ProgressBar) view
					.findViewById(R.id.five_progressBar);
			ImageView img = (ImageView) view.findViewById(R.id.five_img);
			TextView title = (TextView) view.findViewById(R.id.five_title);
			TextView show = (TextView) view.findViewById(R.id.five_show);
			TextView a_class = (TextView) view.findViewById(R.id.five_a_class);
			TextView time = (TextView) view.findViewById(R.id.five_time);

			title.setText(this.data.get(position).getTitle());
			show.setText(this.data.get(position).getShow());
			a_class.setText(this.data.get(position).getA_class());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			String date = sdf
					.format(new Date(this.data.get(position).getTime()));

			time.setText(date);
			// bar.setVisibility(View.INVISIBLE);

			Bitmap bitmap = data.get(position).getImg();

			if (bitmap == null) {

				bitmap = getImg(data.get(position).getImg_url());

				if (bitmap == null) {
					ImgHandler handler = new ImgHandler(position, img, bar,
							this.data.get(position).getImg_url());
					GetImageThread t = new GetImageThread(handler,
							UrlUtil.BASE_URL + "/files/"
									+ this.data.get(position).getImg_url());
					new Thread(t).start();
				}

				else {
					img.setImageBitmap(bitmap);
					bar.setVisibility(View.INVISIBLE);
				
				}

			} else {
				img.setImageBitmap(bitmap);
				bar.setVisibility(View.INVISIBLE);
				
			}

		} else {
			view = inflater.inflate(R.layout.listview_main, null);

			ProgressBar bar = (ProgressBar) view.findViewById(R.id.progressBar);
			ImageView img = (ImageView) view.findViewById(R.id.img);
			TextView title = (TextView) view.findViewById(R.id.title);
			TextView show = (TextView) view.findViewById(R.id.show);
			TextView a_class = (TextView) view.findViewById(R.id.a_class);
			TextView time = (TextView) view.findViewById(R.id.time);

			title.setText(this.data.get(position).getTitle());
			show.setText(this.data.get(position).getShow());
			a_class.setText(this.data.get(position).getA_class());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			String date = sdf
					.format(new Date(this.data.get(position).getTime()));

			time.setText(date);
			// bar.setVisibility(View.INVISIBLE);

			Bitmap bitmap = data.get(position).getImg();

			if (bitmap == null) {

				bitmap = getImg(data.get(position).getImg_url());

				if (bitmap == null) {
					ImgHandler handler = new ImgHandler(position, img, bar,
							this.data.get(position).getImg_url());
					GetImageThread t = new GetImageThread(handler,
							UrlUtil.BASE_URL + "/files/"
									+ this.data.get(position).getImg_url());
					new Thread(t).start();
				}

				else {
					img.setImageBitmap(bitmap);
					bar.setVisibility(View.INVISIBLE);
					
				}

			} else {
				img.setImageBitmap(bitmap);
				bar.setVisibility(View.INVISIBLE);
				
			}
		}
		return view;
	}

	private Bitmap getImg(String img_name) {
		try {
			FileInputStream fis = context.openFileInput(img_name);
			BufferedInputStream bs = new BufferedInputStream(fis);
			Bitmap btp = BitmapFactory.decodeStream(bs);
			btp = ImageUtil.ChangeSizeBitMap(btp, 200);
			return btp;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressLint("HandlerLeak")
	private class ImgHandler extends Handler {

		private int i;
		private ImageView img;
		private ProgressBar bar;
		private String img_name;

		public ImgHandler(int i, ImageView img, ProgressBar bar, String img_name) {
			this.i = i;
			this.img = img;
			this.bar = bar;
			this.img_name = img_name;
		}

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 200) {
				Bitmap bitmap = (Bitmap) msg.obj;
				try {
					FileOutputStream fos = context.openFileOutput(
							this.img_name, Context.MODE_PRIVATE);
					bitmap.compress(CompressFormat.JPEG, 100, fos);
					fos.flush();
					fos.close();

					System.out.println("-------" + this.img_name
							+ "--------xxxx-------------");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				data.get(this.i).setImg((Bitmap) msg.obj);
				if (data.get(this.i).getImg() != null) {
					img.setImageBitmap(data.get(this.i).getImg());
				}
				this.bar.setVisibility(View.INVISIBLE);
			} else if (msg.what == 400) {

			}

		}
	}
	
	private int Mstat = 2;
	
	public class ListViewReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if(intent.getAction().equals("com.redknot.receiver.listview")){
				int stat = intent.getIntExtra("stat", 0);
				System.out.println("!!!!!!!!!!!!!!!!!HHAHAHAHHAHAHAHAHAHAH!!!!!!!!!!!!!");
				Mstat = stat;
				MainListViewAdapter.this.notifyDataSetChanged();
			}
		}
		
	}

}
