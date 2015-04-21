package com.redknot.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

public class Levy {
	public void levy(int x1, int y1, int x2, int y2, int n,
			SurfaceHolder holder, Path path, Paint p) {
		int x3, y3;
		x3 = (int) Math.round(x1 + (x2 - x1) / 2.0 - (y2 - y1) / 2.0);
		y3 = (int) Math.round(y1 + (x2 - x1) / 2.0 + (y2 - y1) / 2.0);

		if (n > 1) {
			levy(x1, y1, x3, y3, n - 1, holder, path, p);
			levy(x3, y3, x2, y2, n - 1, holder, path, p);
		} else {
			Canvas c = holder.lockCanvas();

			if (path.isEmpty()) {
				path.moveTo(x1, y1);
			}

			path.moveTo(x1, y1);
			path.lineTo(x3, y3);
			path.lineTo(x2, y2);
			c.drawColor(Color.WHITE);
			c.drawPath(path, p);
			holder.unlockCanvasAndPost(c);
		}
	}

}
