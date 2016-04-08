package com.redknot.thread;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.redknot.g.G;

public class DrawThread implements Runnable {

	private SurfaceHolder holder;

	public DrawThread(SurfaceHolder holder) {
		this.holder = holder;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// G.bitmap_list.clear();
		Paint paint = new Paint();

		while (true) {

			synchronized (G.bitmap_list) {

				if (G.bitmap_list.size() == 0) {
					continue;
				}

				Bitmap bitmap = G.bitmap_list.get(0);

				try {
					Canvas c = holder.lockCanvas();
					c.drawBitmap(bitmap, 0, 0, paint);
					holder.unlockCanvasAndPost(c);
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}

				G.bitmap_list.remove(0);
			}

		}
	}
}
