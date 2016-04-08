package com.redknot.g;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Bitmap.Config;
import android.view.SurfaceHolder;

public class Sierpinski {
	public void sier_gasket(int xa, int ya, int xb, int yb, int xc, int yc,
			int n, SurfaceHolder holder, Path path, Paint p) {
		Bitmap bitmap = Bitmap
				.createBitmap(G.width, G.height, Config.ARGB_8888);
		Canvas c = new Canvas(bitmap);
		
		int xp, yp, xq, yq, xr, yr;
		xp = Math.round((xb + xc) / 2);
		yp = Math.round((yb + yc) / 2);
		xq = Math.round((xc + xa) / 2);
		yq = Math.round((yc + ya) / 2);
		xr = Math.round((xa + xb) / 2);
		yr = Math.round((ya + yb) / 2);

		if (n > 1) {
			sier_gasket(xa, ya, xr, yr, xq, yq, n - 1, holder, path, p);
			sier_gasket(xb, yb, xp, yp, xr, yr, n - 1, holder, path, p);
			sier_gasket(xc, yc, xq, yq, xp, yp, n - 1, holder, path, p);
		} else {
			
			if (path.isEmpty()) {
				path.moveTo(xp, yp);
			}

			path.moveTo(xp, yp);
			path.lineTo(xq, yq);
			path.lineTo(xr, yr);
			path.lineTo(xp, yp);
			path.moveTo(xa, ya);
			path.lineTo(xb, yb);
			path.lineTo(xc, yc);
			path.lineTo(xa, ya);
			c.drawColor(Color.WHITE);
			c.drawPath(path, p);
			
			G.addBitmap(holder, bitmap);
			
		}

	}
}
