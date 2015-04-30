package com.redknot.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

public class Tree {

	public void tree1(int x1, int y1, int x2, int y2, int n,
			SurfaceHolder holder, Path path, Paint p) {
		int x3, y3, x4, y4, x5, y5;
		x3 = (int) Math.round((2 * x1 + x2) / 3.0);
		y3 = (int) Math.round((2 * y1 + y2) / 3.0);
		float a = 50;
		x4 = (int) Math.round((x2 - x1) * Math.cos(a * Math.PI / 180.0)
				/ 3.0 - (y2 - y1) * Math.sin(a * Math.PI / 180.0) / 3.0
				+ (2.0 * x1 + x2) / 3.0);
		y4 = (int) Math.round((y2 - y1) * Math.cos(a * Math.PI / 180.0)
				/ 3.0 + (x2 - x1) * Math.sin(a * Math.PI / 180.0) / 3.0
				+ (2.0 * y1 + y2) / 3.0);
		x5 = (int) Math.round((x2 - x1) * Math.cos(-a * Math.PI / 180.0)
				/ 3.0 - (y2 - y1) * Math.sin(-a * Math.PI / 180.0) / 3.0
				+ (2.0 * x1 + x2) / 3.0);
		y5 = (int) Math.round((y2 - y1) * Math.cos(-a * Math.PI / 180.0)
				/ 3.0 + (x2 - x1) * Math.sin(-a * Math.PI / 180.0) / 3.0
				+ (2.0 * y1 + y2) / 3.0);
		if (n > 1) {
			tree1(x1, y1, x3, y3, n - 1, holder, path, p);
			tree1(x3, y3, x4, y4, n - 1, holder, path, p);
			tree1(x3, y3, x5, y5, n - 1, holder, path, p);
			tree1(x3, y3, x2, y2, n - 1, holder, path, p);
		} else {
			Canvas c = holder.lockCanvas();
			
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
			holder.unlockCanvasAndPost(c);
		}
	}

}
