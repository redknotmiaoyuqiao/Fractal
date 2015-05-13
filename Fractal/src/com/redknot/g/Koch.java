package com.redknot.g;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Bitmap.Config;
import android.view.SurfaceHolder;

public class Koch {
	public void koch2(int x1, int y1, int x2, int y2, int n,
			SurfaceHolder holder, Path path, Paint p) {

		Bitmap bitmap = Bitmap
				.createBitmap(G.width, G.height, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);

		int x3, y3, x4, y4, x5, y5;
		x3 = (int) Math.round((2.0 * x1 + x2) / 3);
		y3 = (int) Math.round((2.0 * y1 + y2) / 3.0);
		x4 = (int) Math.round((x1 + x2) / 2.0 + (y1 - y2) * Math.sqrt(3.0)
				/ 6.0);
		y4 = (int) Math.round((y1 + y2) / 2.0 + (x2 - x1) * Math.sqrt(3.0)
				/ 6.0);
		x5 = (int) Math.round((2.0 * x2 + x1) / 3.0);
		y5 = (int) Math.round((2 * y2 + y1) / 3.0);

		if (n > 1) {
			koch2(x1, y1, x3, y3, n - 1, holder, path, p);
			koch2(x3, y3, x4, y4, n - 1, holder, path, p);
			koch2(x4, y4, x5, y5, n - 1, holder, path, p);
			koch2(x5, y5, x2, y2, n - 1, holder, path, p);
		} else {

			if (path.isEmpty()) {
				path.moveTo(x1, y1);
			}

			path.lineTo(x1, y1);
			path.lineTo(x3, y3);
			path.lineTo(x4, y4);
			path.lineTo(x5, y5);
			path.lineTo(x2, y2);
			canvas.drawColor(Color.WHITE);
			canvas.drawPath(path, p);

			G.addBitmap(holder, bitmap);

		}

	}

	public void koch1(int x1, int y1, int x2, int y2, int n,
			SurfaceHolder holder, Path path, Paint p) {
		Bitmap bitmap = Bitmap
				.createBitmap(G.width, G.height, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		
		int x3, y3, x4, y4, x5, y5, x6, y6;

		x3 = (int) Math.round((2.0 * x1 + x2) / 3.0);
		y3 = (int) Math.round((2.0 * y1 + y2) / 3.0);
		x4 = (int) Math.round((2.0 * x1 + x2) / 3.0 - (y2 - y1) / 3.0);
		y4 = (int) Math.round((x2 - x1) / 3.0 + (2.0 * y1 + y2) / 3.0);
		x5 = (int) Math.round((2.0 * x2 + x1) / 3.0 - (y2 - y1) / 3.0);
		y5 = (int) Math.round((2 * y2 + y1) / 3.0 + (x2 - x1) / 3.0);
		x6 = (int) Math.round((2.0 * x2 + x1) / 3.0);
		y6 = (int) Math.round((2 * y2 + y1) / 3.0);
		if (n > 1) {
			koch1(x1, y1, x3, y3, n - 1, holder, path, p);
			koch1(x3, y3, x4, y4, n - 1, holder, path, p);
			koch1(x4, y4, x5, y5, n - 1, holder, path, p);
			koch1(x5, y5, x6, y6, n - 1, holder, path, p);
			koch1(x6, y6, x2, y2, n - 1, holder, path, p);
		} else {
			

			if (path.isEmpty()) {
				path.moveTo(x1, y1);
			}

			path.lineTo(x1, y1);
			path.lineTo(x3, y3);
			path.lineTo(x4, y4);
			path.lineTo(x5, y5);
			path.lineTo(x6, y6);
			path.lineTo(x2, y2);
			canvas.drawColor(Color.WHITE);
			canvas.drawPath(path, p);
			
			G.addBitmap(holder, bitmap);
		}
	}
}
