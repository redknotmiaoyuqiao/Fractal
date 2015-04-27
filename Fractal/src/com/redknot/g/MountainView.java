package com.redknot.g;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

public class MountainView {
	public void mountain(SurfaceHolder holder, Paint p){
		
		int i,k,x1,y1;
	    float tempx,x,y,j;
	    
	    float[][] d = new float[9][9];
	    
	    d[1][1]=0.08f;d[1][2]=-0.031f;d[1][3]=0.084f;d[1][4]=0.0306f;d[1][5]=51.7f;d[1][6]=79.7f;  
	    d[2][1]=0.0801f;d[2][2]=0.0212f;d[2][3]=-0.08f;d[2][4]=0.212f;d[2][5]=66.2f;d[2][6]=94f;
	    d[3][1]=0.75f;d[3][2]= 0;d[3][3]=0;d[3][4]=0.53f; d[3][5]=-3.75f;d[3][6]=11.06f;
	    d[4][1]=0.943f;d[4][2]= 0;d[4][3]=0;d[4][4]=0.474f; d[4][5]=-19.8f;d[4][6]=-6.5f;
	    d[5][1]=-0.402f;d[5][2]=0f;d[5][3]=0f;d[5][4]=0.402f;d[5][5]=155.13f;d[5][6]=45.88f;
	    d[6][1]=0.217f;d[6][2]=-0.052f;d[6][3]=0.075f;d[6][4]=0.15f;d[6][5]=30;d[6][6]=57.4f;
	    d[7][1]=0.262f;d[7][2]=-0.105f;d[7][3]=0.114f;d[7][4]=0.241f;d[7][5]=4.73f;d[7][6]=30.45f;
	    d[8][1]=0.22f; d[8][2]=0;d[8][3]=0;d[8][4]=0.43f;d[8][5]=146.0f;d[8][6]=42.86f;
	    
		x = 10000;
		y = 10000;
		j = 1.8f;

		for (i = 0; i < 1000000; i++) {
			tempx = x;
			
			Random random = new Random();
			k = random.nextInt(8)+1;
			//k = (int) Math.random() * 8 + 1;
			
			System.out.println(k);
			x = d[k][1] * tempx + d[k][2] * y + d[k][5];
			y = d[k][3] * tempx + d[k][4] * y + d[k][6];
			x1 = Math.round(x * j) + 200;
			y1 = Math.round(y * j) + 200;

			Canvas c = holder.lockCanvas();
			//c.drawColor(Color.WHITE);
			c.drawPoint(100+x1,700-y1, p);
			//c.drawCircle(x1, y1, 5, p);
			
		
			holder.unlockCanvasAndPost(c);
			// form1.Label3.Canvas.Pixels[40+x1,500-y1]:=colorbox1.Selected;
		}
	}
}
