import processing.core.*; 
import processing.data.*; 

import com.jhlabs.image.*; 
import java.awt.image.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class sketch_01 extends PApplet {




// http://www.jhlabs.com/ip/filters/index.html

PImage original;
PImage pg;
ExposureFilter f;

public void setup() {
   size(800, 800);
   
//   f = new ContrastFilter();
   f = new ExposureFilter();
   original = loadImage("beach.jpeg");

   BufferedImage img = (BufferedImage) original.getImage();
   pg = new PImage(f.filter(img, img));
   image(pg, 0, 0);
}


public void draw() {
  
}

public void keyPressed() {
   if(keyCode == 107) {
//     f.setContrast(f.getContrast()+0.1);
      f.setExposure(f.getExposure()+0.1f);
   } else {
//     f.setContrast(f.getContrast()-0.1);
      f.setExposure(f.getExposure()-0.1f);
   }
    println(f.getExposure());
    BufferedImage img = (BufferedImage) original.getImage();
    pg = new PImage(f.filter(img, img));
    image(pg, 0, 0);
}
  public int sketchWidth() { return 800; }
  public int sketchHeight() { return 800; }
  static public void main(String args[]) {
    PApplet.main(new String[] { "--full-screen", "--bgcolor=#666666", "--hide-stop", "sketch_01" });
  }
}
