package com.redknot.g;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class Landform {
	public void landform(SurfaceHolder holder, Paint p){
		int i,k,x1,y1,j;
	    float tempx,x,y;
	    
	    float[][] d = new float[3][7];
	    
	    d[1][1]=-0.632407f ; d[1][2]=-0.614815f; d[1][3]=-0.545370f;d[1][4]=0.659259f; d[1][5]=38.40822f*3;d[1][6]=12.82321f*3;
	    d[2][1]= -0.036111f;  d[2][2]= 0.444444f ;d[2][3]=0.210185f;d[2][4]=0.037037f;  d[2][5]=20.71081f*3; d[2][6]=83.30552f*3;
	    
	    x=10000;
	    y=10000;
	    j=1;
	    
		for (i = 0; i < 100000; i++) {
			tempx = x;
			Random random = new Random();
			k = random.nextInt(2) + 1;
			x = d[k][1] * tempx + d[k][2] * y + d[k][5];
			y = d[k][3] * tempx + d[k][4] * y + d[k][6];
			x1 = Math.round(x) * j + 200;
			y1 = Math.round(y) * j + 200;

			Canvas c = holder.lockCanvas();

			c.drawPoint(200 + x1, 800 - y1, p);

			System.out.println(x1 + "    " + y1);

			holder.unlockCanvasAndPost(c);
		}
	}
}
