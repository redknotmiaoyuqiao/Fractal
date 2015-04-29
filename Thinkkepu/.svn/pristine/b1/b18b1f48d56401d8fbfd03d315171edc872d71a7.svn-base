package com.redknot.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class ImageUtil {
	public static Bitmap ChangeSizeBitMap(Bitmap bt, int resize) {
		int src_width = bt.getWidth();
		int src_height = bt.getHeight();
		float width = (float) bt.getWidth();
		float height = (float) bt.getHeight();
		float bmpWidth = resize / width;
		float bmpHeight = resize / height;
		if (width >= height) {
			if (width > resize) {
				bmpWidth = resize / height;
				bmpHeight = bmpWidth;
			}
		} else {
			if (height > resize) {
				bmpHeight = resize / height;
				bmpWidth = bmpHeight;
			}
		}

		if (bmpWidth > 1 || bmpHeight > 1) {
			return bt;
		}
		Matrix matrix = new Matrix();
		matrix.postScale(bmpWidth, bmpHeight);
		Bitmap resizeBmp = Bitmap.createBitmap(bt, 0, 0, src_width, src_height,
				matrix, true);
		return resizeBmp;
	}
}
