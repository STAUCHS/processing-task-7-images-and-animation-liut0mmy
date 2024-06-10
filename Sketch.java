import processing.core.PApplet;
import processing.core.PImage;


public class Sketch extends PApplet {


  PImage imgMeteor;
  PImage imgBackground;


  // x and y coordinate for meteor
  float fltMeteorX;
  float fltMeteorY;


  // meteor speed variables
  float fltXSpeed = 3;
  float fltYSpeed = 2;


  // ellipse properties
  float fltEllipseX;
  float fltEllipseY;
  float fltEllipseXSpeed = 4;
  float fltEllipseYSpeed = 3;


  // angle for circular motion
  float angle = 0;


  // define colors
  int black = color(0);
  int white = color(255);
  int magenta = color(255, 0, 255);


  public void settings() {
    size(400, 400);
  }


  public void setup() {
    // load background
    imgBackground = loadImage("spaceBackground.jpg");
    imgBackground.resize(width, height);


    // load meteor
    imgMeteor = loadImage("spaceMeteors_003.png");
    imgMeteor.resize(50, 50);


    // initialize positions
    fltMeteorX = width / 2;
    fltMeteorY = height / 2;
    fltEllipseX = random(width);
    fltEllipseY = random(height);
  }


  public void draw() {
    // draw background
    background(imgBackground);


    // draw and move meteor in circular path
    float circularPathRadius = 100;
    fltMeteorX = width / 2 + circularPathRadius * cos(angle);
    fltMeteorY = height / 2 + circularPathRadius * sin(angle);
    angle += 0.05;
    image(imgMeteor, fltMeteorX - imgMeteor.width / 2, fltMeteorY - imgMeteor.height / 2);


    // draw and move ellipse
    fill(255);
    ellipse(fltEllipseX, fltEllipseY, 50, 50);


    fltEllipseX += fltEllipseXSpeed;
    fltEllipseY += fltEllipseYSpeed;


    // edge collision detection for ellipse
    if (fltEllipseX > width - 25 || fltEllipseX < 25) {
      fltEllipseXSpeed *= -1;
    }


    if (fltEllipseY > height - 25 || fltEllipseY < 25) {
      fltEllipseYSpeed *= -1;
    }
  }


  public static void main(String[] args) {
    PApplet.main("Sketch");
  }
}
