package com.redknot.g;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

public class Leaf {

	public void leaf2(float x, float y, float L, float A,
			SurfaceHolder holder, Path path, Paint p) {
		float B, C, s1, s2, s3;
		float x1, y1, x1L, y1L, x1R, y1R, x2, y2, x2R, y2R, x2L, y2L;
		B = 50;
		C = 9;
		s1 = 2;
		s2 = 3;
		s3 = 1.3f;

		if (L > s1) {
			x2 = (float) (x + L * Math.cos(A * Math.PI));
			y2 = (float) (y + L * Math.sin(A * Math.PI));
			x2R = (float) (x2 + L / s2 * Math.cos((A + B) * Math.PI));
			y2R = (float) (y2 + L / s2 * Math.sin((A + B) * Math.PI));
			x2L = (float) (x2 + L / s2 * Math.cos((A - B) * Math.PI));
			y2L = (float) (y2 + L / s2 * Math.sin((A - B) * Math.PI));
			x1 = (float) (x + L / s2 * Math.cos(A * Math.PI));
			y1 = (float) (y + L / s2 * Math.sin(A * Math.PI));
			x1L = (float) (x1 + L / s2 * Math.cos((A - B) * Math.PI));
			y1L = (float) (y1 + L / s2 * Math.sin((A - B) * Math.PI));
			x1R = (float) (x1 + L / s2 * Math.cos((A + B) * Math.PI));
			y1R = (float) (y1 + L / s1 * Math.sin((A + B) * Math.PI));
			
			Canvas c = holder.lockCanvas();

			if (path.isEmpty()) {
				path.moveTo(x1, y1);
			}

			path.moveTo(Math.round(x),Math.round(y));
			path.lineTo(Math.round(x2),Math.round(y2));
			path.lineTo(Math.round(x2R),Math.round(y2R));
			path.moveTo(Math.round(x2),Math.round(y2));
			path.lineTo(Math.round(x2L),Math.round(y2L));
			path.moveTo(Math.round(x1),Math.round(y1));
			path.lineTo(Math.round(x1L),Math.round(y1L));
			path.moveTo(Math.round(x1),Math.round(y1));
			path.lineTo(Math.round(x1R),Math.round(y1R));
			
			c.drawColor(Color.WHITE);
			c.drawPath(path, p);
			holder.unlockCanvasAndPost(c);
			
			
			// Form1.label3.Canvas.MoveTo(Round(x),Round(y));
			// Form1.label3.Canvas.LineTo(Round(x2),Round(y2));
			// Form1.label3.Canvas.LineTo(Round(x2R),Round(y2R));
			// Form1.label3.Canvas.MoveTo(Round(x2),Round(y2));
			// Form1.label3.Canvas.LineTo(Round(x2L),Round(y2L));
			// Form1.label3.Canvas.MoveTo(Round(x1),Round(y1));
			// Form1.label3.Canvas.LineTo(Round(x1L),Round(y1L));
			// Form1.label3.Canvas.MoveTo(Round(x1),Round(y1));
			// Form1.label3.Canvas.LineTo(Round(x1R),Round(y1R));

			leaf2(Math.round(x2), Math.round(y2), Math.round(L / s3), A + C,holder,path,p);
			leaf2(Math.round(x2R), Math.round(y2R), Math.round(L / s2), A + B,holder,path,p);
			leaf2(Math.round(x2L), Math.round(y2L), Math.round(L / s2), A - B,holder,path,p);
			leaf2(Math.round(x1L), Math.round(y1L), Math.round(L / s2), A - B,holder,path,p);
			leaf2(Math.round(x1R), Math.round(y1R), Math.round(L / s2), A + B,holder,path,p);
		}
	}

	public void leaf(SurfaceHolder holder, Paint p) {
		int i, k, x1, y1;
		float tempx, x, y, j;

		float[][] d = new float[7][7];

		d[1][1] = 0.35173f;
		d[1][2] = 0.35537f;
		d[1][3] = -0.35537f;
		d[1][4] = 0.35173f;
		d[1][5] = 35.45f * 4;
		d[1][6] = 50 * 4;
		d[2][1] = 0.35338f;
		d[2][2] = -0.3537f;
		d[2][3] = 0.35373f;
		d[2][4] = 0.35338f;
		d[2][5] = 28.79f * 4;
		d[2][6] = 15.28f * 4;
		d[3][1] = 0.5f;
		d[3][2] = 0f;
		d[3][3] = 0f;
		d[3][4] = 0.5f;
		d[3][5] = 25 * 4;
		d[3][6] = 46.2f * 4;
		d[4][1] = 0.5154f;
		d[4][2] = -0.0018f;
		d[4][3] = 0.00157f;
		d[4][4] = 0.58795f;
		d[4][5] = 25.01f * 4;
		d[4][6] = 10.54f * 4;
		d[5][1] = 0.00364f;
		d[5][2] = 0;
		d[5][3] = 0f;
		d[5][4] = 0.57832f;
		d[5][5] = 50.16f * 4;
		d[5][6] = 6.06f * 4;

		x = 10000;
		y = 10000;
		j = 1.5f;
		for (i = 0; i < 1000; i++) {
			Canvas c = holder.lockCanvas();
			for (int w = 0; w < 300; w++) {
				tempx = x;

				Random random = new Random();
				k = random.nextInt(5) + 1;
				x = d[k][1] * tempx + d[k][2] * y + d[k][5];
				y = d[k][3] * tempx + d[k][4] * y + d[k][6];
				x1 = Math.round(x * j) + 100;
				y1 = Math.round(y * j);

				c.drawPoint(0 + x1, 600 - y1, p);
			}
			holder.unlockCanvasAndPost(c);

		}

	}
}
