package com.android.code.calss;

import android.graphics.Bitmap;

public class ResizeBitmap {
	public Bitmap resizeBitmap(Bitmap bm, int maxWidth, int maxHeight) {
		int newWidth, newHeight;
		int bmWidth = bm.getWidth();
		int bmHeight = bm.getHeight();
		if(bmWidth > maxWidth && (maxWidth * bmHeight) / bmWidth < maxHeight) {
			newWidth = maxWidth;
			newHeight = (maxWidth * bmHeight) / bmWidth;
		} else {
			newWidth = (maxHeight * bmWidth) / bmHeight;
			newHeight = maxHeight;
		}
		return Bitmap.createScaledBitmap(bm, newWidth, newHeight, false);
	}
}
