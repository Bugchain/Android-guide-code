package tool;

import android.graphics.Bitmap;
import android.graphics.Color;

public class BlurImage {

	public Bitmap getBlurBitmap(Bitmap src) {
		  
		  final int widthKernal = 4;
		  final int heightKernal = 4;

		  int w = src.getWidth();
		  int h = src.getHeight();

		  Bitmap blurBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

		  for (int x = 0; x < w; x++) {
		   for (int y = 0; y < h; y++) {

		    int r = 0;
		    int g = 0;
		    int b = 0;
		    int a = 0;
		    
		    for (int xk = 0; xk < widthKernal; xk++) {
		     for (int yk = 0; yk < heightKernal; yk++) {
		      int px = x + xk -2;
		      int py = y + yk -2;

		      if(px < 0){
		       px = 0;
		      }else if(px >= w){
		       px = w-1;
		      }
		      
		      if(py < 0){
		       py = 0;
		      }else if(py >= h){
		       py = h-1;
		      }
		      
		      int intColor = src.getPixel(px, py);
		      r += Color.red(intColor);
		      g += Color.green(intColor);
		      b += Color.blue(intColor);
		      a += Color.alpha(intColor);
		      
		     }
		    }
		    
		    blurBitmap.setPixel(x, y, Color.argb(a/25, r/25, g/25, b/25));

		   }
		  }

		  return blurBitmap;
		 }
	
}
