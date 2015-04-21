package com.redknot.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

public class Huangguan {
	public void huangguan(int x1, int y1, int x2, int y2, int n,
			SurfaceHolder holder, Path path, Paint p) {
		int x3, y3, x4, y4, x5, y5, x6, y6, x7, y7;
		x3 = (int) Math.round(x1 + Math.sqrt(3) * (x2 - x1)
				/ (2.0 * (Math.sqrt(3) + 1)) + (y2 - y1)
				/ (2.0 * (Math.sqrt(3) + 1)));
		y3 = (int) Math.round(y1 + Math.sqrt(3) * (y2 - y1)
				/ (2.0 * (Math.sqrt(3) + 1)) - (x2 - x1)
				/ (2.0 * (Math.sqrt(3) + 1)));
		x4 = (int) Math.round(x3 - (y2 - y1) / (Math.sqrt(3) + 1));
		y4 = (int) Math.round(y3 + (x2 - x1) / (Math.sqrt(3) + 1));
		x5 = (int) Math.round(x4 + (x2 - x1) / (2.0 * (Math.sqrt(3) + 1))
				+ (y2 - y1) * Math.sqrt(3) / (2.0 * (Math.sqrt(3) + 1)));
		y5 = (int) Math.round(y4 + (y2 - y1) / (2.0 * (Math.sqrt(3) + 1))
				- (x2 - x1) * Math.sqrt(3) / (2.0 * (Math.sqrt(3) + 1)));
		x6 = (int) Math.round(x4 + (x2 - x1) / (Math.sqrt(3) + 1));
		y6 = (int) Math.round(y4 + (y2 - y1) / (Math.sqrt(3) + 1));
		x7 = (int) Math.round(x3 + (x2 - x1) / (Math.sqrt(3) + 1));
		y7 = (int) Math.round(y3 + (y2 - y1) / (Math.sqrt(3) + 1));
		if (n > 1) {
			huangguan(x1, y1, x3, y3, n - 1, holder, path, p);
			huangguan(x3, y3, x4, y4, n - 1, holder, path, p);
			huangguan(x4, y4, x5, y5, n - 1, holder, path, p);
			huangguan(x5, y5, x6, y6, n - 1, holder, path, p);
			huangguan(x6, y6, x7, y7, n - 1, holder, path, p);
			huangguan(x7, y7, x2, y2, n - 1, holder, path, p);
		} else {
			Canvas c = holder.lockCanvas();

			if (path.isEmpty()) {
				path.moveTo(x1, y1);
			}

			path.moveTo(x1, y1);
			path.lineTo(x3, y3);
			path.lineTo(x4, y4);
			path.lineTo(x5, y5);
			path.lineTo(x6, y6);
			path.lineTo(x7, y7);
			path.lineTo(x2, y2);
			c.drawColor(Color.WHITE);
			c.drawPath(path, p);
			holder.unlockCanvasAndPost(c);
		}
	}

}
