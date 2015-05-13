package com.redknot.thread;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.redknot.g.G;
import com.redknot.weibo.Screen;

public class DrawThread implements Runnable {

	private SurfaceHolder holder;

	public DrawThread(SurfaceHolder holder) {
		this.holder = holder;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		G.bitmap_list.clear();

		Paint paint = new Paint();

		while (true) {
			long time1 = System.currentTimeMillis();
			try {

				if (G.bitmap_list.size() == 0) {
					continue;
				}

				Bitmap bitmap = G.bitmap_list.get(0);

				Canvas c = holder.lockCanvas();
				//c.drawColor(Color.WHITE);
				c.drawBitmap(bitmap, 0, 0, paint);
				
				Screen.Bmp = bitmap;

				holder.unlockCanvasAndPost(c);
				
				G.bitmap_list.remove(0);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
			long time2 = System.currentTimeMillis();
			//System.out.println(time2 - time1);
		}
	}
}
