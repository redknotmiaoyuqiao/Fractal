package com.redknot.g;

import java.util.ArrayList;
import java.util.List;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class G {
	public static List<Bitmap> bitmap_list = new ArrayList<Bitmap>();
	
	public static boolean isDraw = false;

	public static void addBitmap(SurfaceHolder holder, Bitmap bitmap) {
		
		Canvas c = holder.lockCanvas();
		Paint paint = new Paint();
		//Screen.Bmp = bitmap;
		c.drawBitmap(bitmap, 0, 0, paint);
		holder.unlockCanvasAndPost(c);
	
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
