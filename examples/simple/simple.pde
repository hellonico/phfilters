import net.hellonico.phfilters.*;
import com.jhlabs.image.*;

// http://www.jhlabs.com/ip/filters/index.html

PFilterLibrary pf = new PFilterLibrary();

PImage original;
PImage pg;

ExposureFilter f;
//ContrastFilter f;

void setup() {
   size(800, 800);
   
   //   f = new ContrastFilter();
   f = new ExposureFilter();
   original = loadImage("beach.jpeg");
   image(original, 0, 0);
}

void applyFilter() {
    
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
    image(pf.apply(original, f), 0, 0);
}