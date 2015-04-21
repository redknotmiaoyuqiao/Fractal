package com.redknot.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

public class Hualan {
	public void hualan(int x1, int y1, int x2, int y2, int n,
			SurfaceHolder holder, Path path, Paint p) {

		int x3, y3, x4, y4, x5, y5, x6, y6;
		x3 = (int) Math.round((x2 + x1) / 2.0 - (y2 - y1)
				/ (3.0 * Math.sqrt(5)));
		y3 = (int) Math.round((y2 + y1) / 2.0 + (x2 - x1)
				/ (3.0 * Math.sqrt(5)));
		x4 = (int) Math.round(2.0 * x1 / 5.0 + 3.0 * x2 / 5.0 - (y2 - y1)
				/ (3.0 * Math.sqrt(5)));
		y4 = (int) Math.round(2.0 * y1 / 5.0 + 3.0 * y2 / 5.0 + (x2 - x1)
				/ (3.0 * Math.sqrt(5)));
		x5 = (int) Math.round((x1 + x2) / 2.0 - (y2 - y1) / Math.sqrt(5));
		y5 = (int) Math.round((y1 + y2) / 2.0 + (x2 - x1) / Math.sqrt(5));
		x6 = (int) Math.round(3.0 * x1 / 5.0 + 2.0 * x2 / 5.0 - (y2 - y1)
				/ (3.0 * Math.sqrt(5)));
		y6 = (int) Math.round(3.0 * y1 / 5.0 + 2.0 * y2 / 5.0 + (x2 - x1)
				/ (3.0 * Math.sqrt(5)));

		if (n > 1) {
			hualan(x1, y1, x3, y3, n - 1, holder, path, p);
			hualan(x3, y3, x4, y4, n - 1, holder, path, p);
			hualan(x4, y4, x5, y5, n - 1, holder, path, p);
			hualan(x5, y5, x6, y6, n - 1, holder, path, p);
			hualan(x6, y6, x3, y3, n - 1, holder, path, p);
			hualan(x3, y3, x2, y2, n - 1, holder, path, p);
		} else {
			Canvas c = holder.lockCanvas();

			if (path.isEmpty()) {
				path.moveTo(x1, y1);
			}

			path.lineTo(x1, y1);
			path.lineTo(x3, y3);
			path.lineTo(x4, y4);
			path.lineTo(x5, y5);
			path.lineTo(x6, y6);
			path.lineTo(x3, y3);
			path.lineTo(x2, y2);
			c.drawColor(Color.WHITE);
			c.drawPath(path, p);
			holder.unlockCanvasAndPost(c);
		}
	}
}
