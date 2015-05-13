package com.redknot.g;

import java.util.ArrayList;
import java.util.List;

import com.redknot.thread.DrawThread;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class G {
	public static List<Bitmap> bitmap_list = new ArrayList<Bitmap>();

	public static void addBitmap(SurfaceHolder holder, Bitmap bitmap) {
		long time1 = System.currentTimeMillis();
		while (G.bitmap_list.size() > 2) {

			long time2 = System.currentTimeMillis();
			if ((time2 - time1) > 100) {
				Canvas c = holder.lockCanvas();
				holder.unlockCanvasAndPost(c);
			}
		}

		synchronized (G.bitmap_list) {
			G.bitmap_list.add(bitmap);
		}
	}

	public static int width;
	public static int height;

	public static int id = -1;
	public static int n = 0;
	public static int color = 0;

	public static float Scale = 0;
	public static float Angle_L = 0;
	public static float Angle_R = 0;
}
