package com.redknot.g;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class Leaf {
	public void leaf(SurfaceHolder holder, Paint p){
		int i,k,x1,y1;
	    float tempx,x,y,j;
	    
	    float[][] d = new float[7][7];
	    
	    d[1][1]=0.35173f;d[1][2]=0.35537f;d[1][3]=-0.35537f;d[1][4]=0.35173f;d[1][5]=35.45f*4;d[1][6]=50*4;
	    d[2][1]=0.35338f;d[2][2]=-0.3537f;d[2][3]=0.35373f;d[2][4]=0.35338f;d[2][5]=28.79f*4;d[2][6]=15.28f*4;
	    d[3][1]=0.5f;d[3][2]= 0f;d[3][3]=0f;d[3][4]=0.5f; d[3][5]=25*4;d[3][6]=46.2f*4;
	    d[4][1]=0.5154f;d[4][2]=-0.0018f;d[4][3]=0.00157f;d[4][4]=0.58795f; d[4][5]=25.01f*4;d[4][6]=10.54f*4;
	    d[5][1]=0.00364f;d[5][2]=0;d[5][3]=0f;d[5][4]=0.57832f;d[5][5]=50.16f*4;d[5][6]=6.06f*4;
	    
	    x=10000;
	    y=10000;
	    j=1.5f;
		for (i = 0; i < 100000; i++) {
			tempx = x;

			Random random = new Random();
			k = random.nextInt(5) + 1;
			x = d[k][1] * tempx + d[k][2] * y + d[k][5];
			y = d[k][3] * tempx + d[k][4] * y + d[k][6];
			x1 = Math.round(x * j) + 100;
			y1 = Math.round(y * j);

			Canvas c = holder.lockCanvas();
			
			c.drawPoint(0 + x1, 600 - y1, p);

			holder.unlockCanvasAndPost(c);
			
		}
	   
	}
}

