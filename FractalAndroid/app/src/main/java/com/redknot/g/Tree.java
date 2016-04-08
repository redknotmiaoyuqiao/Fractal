package com.redknot.g;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Bitmap.Config;
import android.view.SurfaceHolder;

public class Tree {

	public void Tree2(int X1, int Y1, int X2, int Y2, int n, float Scale,
			float Angle_L, float Angle_R, SurfaceHolder holder, Path path,
			Paint p) {
		Bitmap bitmap = Bitmap
				.createBitmap(G.width, G.height, Config.ARGB_8888);
		Canvas c = new Canvas(bitmap);
		
		
		int X3, Y3, X4, Y4, X5, Y5, X6, Y6;
		X3 = Math.round(X1 + Scale * (X2 - X1));
		Y3 = Math.round(Y1 + Scale * (Y2 - Y1));
		X4 = (int) Math.round(X3
				+ Scale
				* (Math.cos(Angle_R * Math.PI / 180.0) * (X2 - X1) - Math
						.sin(Angle_R * Math.PI / 180.0) * (Y2 - Y1)));
		Y4 = (int) Math.round(Y3
				+ Scale
				* (Math.cos(Angle_R * Math.PI / 180.0) * (Y2 - Y1) + Math
						.sin(Angle_R * Math.PI / 180.0) * (X2 - X1)));
		X5 = Math.round(X1 + 2 * Scale * (X2 - X1));
		Y5 = Math.round(Y1 + 2 * Scale * (Y2 - Y1));
		X6 = (int) Math.round(X5
				+ Scale
				* (Math.cos(Angle_L * Math.PI / 180.0) * (X2 - X1) + Math
						.sin(Angle_L * Math.PI / 180.0) * (Y2 - Y1)));
		Y6 = (int) Math.round(Y5
				+ Scale
				* (Math.cos(Angle_L * Math.PI / 180.0) * (Y2 - Y1) - Math
						.sin(Angle_L * Math.PI / 180.0) * (X2 - X1)));

		if (n > 1) {
			Tree2(X1, Y1, X3, Y3, n - 1, Scale, Angle_L, Angle_R, holder, path,
					p);
			Tree2(X3, Y3, X4, Y4, n - 1, Scale, Angle_L, Angle_R, holder, path,
					p);
			Tree2(X3, Y3, X5, Y4, n - 1, Scale, Angle_L, Angle_R, holder, path,
					p);
			Tree2(X5, Y5, X6, Y6, n - 1, Scale, Angle_L, Angle_R, holder, path,
					p);
			Tree2(X5, Y5, X2, Y2, n - 1, Scale, Angle_L, Angle_R, holder, path,
					p);
		} else {
			path.moveTo(X1, Y1);
			path.lineTo(X3, Y3);
			path.lineTo(X4, Y4);
			path.moveTo(X3, Y3);
			path.lineTo(X5, Y5);
			path.lineTo(X6, Y6);
			path.moveTo(X5, Y5);
			path.lineTo(X2, Y2);
			
			

			if (path.isEmpty()) {
				path.moveTo(X1, Y1);
			}
			c.drawColor(Color.WHITE);
			c.drawPath(path, p);
			
			G.addBitmap(holder, bitmap);
		}
	}

	public void tree1(int x1, int y1, int x2, int y2, int n,
			SurfaceHolder holder, Path path, Paint p) {
		Bitmap bitmap = Bitmap
				.createBitmap(G.width, G.height, Config.ARGB_8888);
		Canvas c = new Canvas(bitmap);
		
		int x3, y3, x4, y4, x5, y5;
		x3 = (int) Math.round((2 * x1 + x2) / 3.0);
		y3 = (int) Math.round((2 * y1 + y2) / 3.0);
		float a = 50;
		x4 = (int) Math.round((x2 - x1) * Math.cos(a * Math.PI / 180.0) / 3.0
				- (y2 - y1) * Math.sin(a * Math.PI / 180.0) / 3.0
				+ (2.0 * x1 + x2) / 3.0);
		y4 = (int) Math.round((y2 - y1) * Math.cos(a * Math.PI / 180.0) / 3.0
				+ (x2 - x1) * Math.sin(a * Math.PI / 180.0) / 3.0
				+ (2.0 * y1 + y2) / 3.0);
		x5 = (int) Math.round((x2 - x1) * Math.cos(-a * Math.PI / 180.0) / 3.0
				- (y2 - y1) * Math.sin(-a * Math.PI / 180.0) / 3.0
				+ (2.0 * x1 + x2) / 3.0);
		y5 = (int) Math.round((y2 - y1) * Math.cos(-a * Math.PI / 180.0) / 3.0
				+ (x2 - x1) * Math.sin(-a * Math.PI / 180.0) / 3.0
				+ (2.0 * y1 + y2) / 3.0);
		if (n > 1) {
			tree1(x1, y1, x3, y3, n - 1, holder, path, p);
			tree1(x3, y3, x4, y4, n - 1, holder, path, p);
			tree1(x3, y3, x5, y5, n - 1, holder, path, p);
			tree1(x3, y3, x2, y2, n - 1, holder, path, p);
		} else {
			

			if (path.isEmpty()) {
				path.moveTo(x1, y1);
			}

			path.moveTo(x1, y1);
			path.lineTo(x3, y3);
			path.lineTo(x4, y4);
			path.moveTo(x3, y3);
			path.lineTo(x5, y5);
			path.moveTo(x3, y3);
			path.lineTo(x2, y2);
			c.drawColor(Color.WHITE);
			c.drawPath(path, p);
			
			G.addBitmap(holder, bitmap);
		}
	}

}
