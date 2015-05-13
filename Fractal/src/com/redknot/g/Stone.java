package com.redknot.g;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.view.SurfaceHolder;

public class Stone {
	public void stone(SurfaceHolder holder, Paint p){
		Bitmap bitmap = Bitmap
				.createBitmap(G.width, G.height, Config.ARGB_8888);
		Canvas c = new Canvas(bitmap);
		c.drawColor(Color.WHITE);
		
		
		int i,k,j,x1,y1;
	    float tempx,x,y;
	    
	    float[][] d = new float[5][7];
	    
	    d[1][1]=0.3535f;d[1][2]=0.3535f;d[1][3]=-0.3535f;d[1][4]=0.3535f;d[1][5]=40*3;d[1][6]=-30*3;
	    d[2][1]=0.3535f;d[2][2]=-0.3535f;d[2][3]=0.3535f;d[2][4]=0.3535f;d[2][5]=-40*3;d[2][6]=30*3;
	    d[3][1]=0.5f;d[3][2]=0;d[3][3]=0;d[3][4]=0.4f; d[3][5]=0;d[3][6]=30*3;
	    d[4][1]=0.5f;d[4][2]=0;d[4][3]=0;d[4][4]=0.1f; d[4][5]=0;d[4][6]=-30*3;
	    
	    x=10000;
	    y=10000;
	    j=1;
		for (i = 0; i < 1000; i++) {
			
			for (int w = 0; w < 300; w++) {
				tempx = x;
				Random random = new Random();
				k = random.nextInt(4) + 1;
				x = d[k][1] * tempx + d[k][2] * y + d[k][5];
				y = d[k][3] * tempx + d[k][4] * y + d[k][6];
				x1 = Math.round(x) * j + 200;
				y1 = Math.round(y) * j + 100;

				c.drawPoint(230 + x1, 600 - y1, p);

				System.out.println(x1 + "    " + y1);
			}

			G.addBitmap(holder, bitmap);
		}
	}
}
