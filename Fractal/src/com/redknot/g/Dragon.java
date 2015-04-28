package com.redknot.g;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class Dragon {
	public void dragon(SurfaceHolder holder, Paint p) {
		int i, k, j, x1, y1;
		float tempx, x, y;

		float[][] d = new float[3][7];

		d[1][1] = 0.5f;
		d[1][2] = -0.5f;
		d[1][3] = 0.5f;
		d[1][4] = 0.5f;
		d[1][5] = 100;
		d[1][6] = 0;
		d[2][1] = 0.5f;
		d[2][2] = -0.5f;
		d[2][3] = 0.5f;
		d[2][4] = 0.5f;
		d[2][5] = -100;
		d[2][6] = 0;

		x = 10000;
		y = 10000;
		j = 1;

		for (i = 0; i < 3000; i++) {

			Canvas c = holder.lockCanvas();

			for (int w = 0; w < 500; w++) {
				tempx = x;
				Random random = new Random();
				k = random.nextInt(2) + 1;
				x = d[k][1] * tempx + d[k][2] * y + d[k][5];
				y = d[k][3] * tempx + d[k][4] * y + d[k][6];
				x1 = Math.round(x) * j + 200;
				y1 = Math.round(y) * j + 100;
				
				c.drawPoint(200 + x1, 650 - y1, p);
			}

			holder.unlockCanvasAndPost(c);
			System.out.println(i);
		}
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
}
