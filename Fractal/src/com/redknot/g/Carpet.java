package com.redknot.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

public class Carpet {
	public void carpet(int x1, int y1, int x2, int y2, int n,
			SurfaceHolder holder, Path path, Paint p) {

		int L, W;
		if (n > 1) {
			L = x2 - x1;
			W = y2 - y1;
			Canvas c = holder.lockCanvas();

			path.moveTo(Math.round(x1 + L / 3), Math.round(y1 + W / 3));
			path.lineTo(Math.round(x2 - L / 3), Math.round(y1 + W / 3));
			path.lineTo(Math.round(x2 - L / 3), Math.round(y2 - W / 3));
			path.lineTo(Math.round(x1 + L / 3), Math.round(y2 - W / 3));
			path.lineTo(Math.round(x1 + L / 3), Math.round(y1 + W / 3));
			
			c.drawColor(Color.WHITE);
			c.drawPath(path, p);

			holder.unlockCanvasAndPost(c);

			carpet(x1, y1, x1 + L / 3, y1 + W / 3, n - 1, holder, path, p);
			carpet(x1 + L / 3, y1, x2 - L / 3, y1 + W / 3, n - 1, holder, path,
					p);
			carpet(x2 - L / 3, y1, x2, y1 + W / 3, n - 1, holder, path, p);
			carpet(x1, y1 + W / 3, x1 + L / 3, y2 - W / 3, n - 1, holder, path,
					p);
			carpet(x2 - L / 3, y1 + W / 3, x2, y2 - W / 3, n - 1, holder, path,
					p);
			carpet(x1, y2 - W / 3, x1 + L / 3, y2, n - 1, holder, path, p);
			carpet(x1 + L / 3, y2 - W / 3, x2 - L / 3, y2, n - 1, holder, path,
					p);
			carpet(x2 - L / 3, y2 - W / 3, x2, y2, n - 1, holder, path, p);
		}

	}
}
