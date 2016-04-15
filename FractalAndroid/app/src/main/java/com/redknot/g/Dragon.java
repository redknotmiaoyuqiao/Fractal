package com.redknot.g;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.view.SurfaceHolder;

public class Dragon {
    public void dragon(SurfaceHolder holder, Paint p) {
        Bitmap bitmap = Bitmap
                .createBitmap(G.width, G.height, Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);

        c.drawColor(Color.WHITE);


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

        for (i = 0; i < 5000; i++) {

            for (int w = 0; w < 300; w++) {
                tempx = x;
                Random random = new Random();
                k = random.nextInt(2) + 1;
                x = d[k][1] * tempx + d[k][2] * y + d[k][5];
                y = d[k][3] * tempx + d[k][4] * y + d[k][6];
                x1 = Math.round(x) * j;
                y1 = Math.round(y) * j;
                c.drawPoint(x1 + G.width / 2, y1 + G.height / 2, p);
            }
            G.addBitmap(holder, bitmap);
        }

    }
}
