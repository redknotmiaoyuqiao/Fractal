package com.redknot.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class Newton {

	public void newton(float cx, float cy,SurfaceHolder holder, Paint p) {
		float R = 9.0f;
		int k, l, couleur;
		float x, y, z, w;
		int co = Color.BLACK;
		float A, B, C, D;

		for (k = -100; k < 500; k++) {
			Canvas c = holder.lockCanvas();
			for (l = -100; l < 500; l++) {
				x = (k + 100) / 150 - 2;
				y = (l + 100) / 150 - 2;
				couleur = 0;
				while (true) {
					System.out.println("hahhahahahahahahah");
					A = 6
							* (x * x * x * x * x + 5 * x * y * y * y * y - 10
									* x * x * x * y * y) + cx - 1;
					B = (float) (6 * (5 * y * x * x * x * x + y * y * y * y * y - 10
							* x*x * y * y*y) + cy);
					C = (float) (5 * x*x * x*x
							* (x*x) - y*y*y*y
							* y*y - 15 * x * x * x * x * y*y + 15
							* x*x * y*y*y*y + 1 - cx);
					D = 5
							* (6 * y * x * x * x * x * x + 6 * x * y * y * y
									* y * y - 20 * x * x * x * y * y * y) - cy;

					z = (float) ((A * C + B * D) / (A*A) + (B*B));
					w = (float) ((A * D - B * C) / (A*A) + (B*B));
					x = z;
					y = w;
					couleur = couleur + 1;
					//System.out.println(couleur);
					if(((x*x+y*y)>R) || (couleur==30)){
						
						break;
					}
				}

				if (couleur == 0) {
					co = Color.BLACK;
				} else if (couleur == 1) {
					co = Color.CYAN;
				} else if (couleur == 2) {
					co = Color.GREEN;
				} else if (couleur == 3) {
					co = Color.BLUE;
				} else if (couleur == 4) {
					co = Color.YELLOW;
				} else if (couleur == 5) {
					co = Color.RED;
				} else if (couleur == 6) {
					co = Color.DKGRAY;
				} else if (couleur == 7) {
					co = Color.GRAY;
				} else if (couleur == 8) {
					co = Color.MAGENTA;
				} else if (couleur == 9) {
					co = Color.TRANSPARENT;
				} else if (couleur == 10) {
					co = Color.WHITE;
				} else if (couleur == 11) {
					co = Color.LTGRAY;
				} else if (couleur == 12) {
					co = Color.WHITE;
				} else if (couleur == 13) {
					co = Color.YELLOW;
				}
				else{
					co = Color.WHITE;
				}
				
				
				
				p.setColor(co);

				c.drawPoint(k+100,l+100, p);
				
				

			}
			
			holder.unlockCanvasAndPost(c);
		}
	}
}
