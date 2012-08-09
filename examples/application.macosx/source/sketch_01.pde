import com.jhlabs.image.*;
import java.awt.image.*;

// http://www.jhlabs.com/ip/filters/index.html

PImage original;
PImage pg;
ExposureFilter f;

void setup() {
   size(800, 800);
   
//   f = new ContrastFilter();
   f = new ExposureFilter();
   original = loadImage("beach.jpeg");

   BufferedImage img = (BufferedImage) original.getImage();
   pg = new PImage(f.filter(img, img));
   image(pg, 0, 0);
}


void draw() {
  
}

void keyPressed() {
   if(keyCode == 107) {
//     f.setContrast(f.getContrast()+0.1);
      f.setExposure(f.getExposure()+0.1);
   } else {
//     f.setContrast(f.getContrast()-0.1);
      f.setExposure(f.getExposure()-0.1);
   }
    println(f.getExposure());
    BufferedImage img = (BufferedImage) original.getImage();
    pg = new PImage(f.filter(img, img));
    image(pg, 0, 0);
}
