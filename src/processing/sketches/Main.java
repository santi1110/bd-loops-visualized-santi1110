package processing.sketches;

import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet sketch;
    private PaperStyle paperMode = PaperStyle.NONE;

    public enum PaperStyle {
        NONE,
        LINED,
        GRID,
        DOT,
        PRETTY
    }

    public void settings() {
        sketch = this;
        size(640, 960);
    }

    public void setup() {
        colorMode(HSB, 360, 100, 100);
    }

    public void draw() {
        background(360);

        switch (paperMode) {
            case LINED:
                drawLinedPaper(80, 100, 30);
                break;
            case GRID:
                drawGridPaper(24, true);
                break;
            case DOT:
                drawDotPaper(16, 3);
                break;
            case PRETTY:
                drawPrettyPaper();
                break;
        }

        menu();
    }

    public void drawLinedPaper(int leftMargin, int topMargin, int gapHeight) {
        // TODO: Finish this method.
        stroke(0, 30, 100);
        line(leftMargin, 0, leftMargin, height);

        stroke(240, 30, 100);
        int lineNumber = 0;
        while (topMargin + lineNumber * gapHeight < height) {
            line(0, topMargin + lineNumber * gapHeight, width, topMargin + lineNumber * gapHeight);
            lineNumber++;
        }
    }

    public void drawGridPaper(int boxLength, boolean isEngineer) {
        // TODO: Finish this method.
        //vertical stroke
        stroke(0, 30, 100);

        int lineNumber = 0;
        for (int x = boxLength; x < width; x += boxLength){
            if (lineNumber % 5 == 1) {
                strokeWeight(3);
            }else{
                strokeWeight(1);
            }
            line(x, 0, x, height);
            lineNumber++;
        }
        //horizontal stroke
        stroke(210, 30, 100);
        lineNumber = 0;
        for (int y = boxLength; y < height; y += boxLength){
            if (lineNumber % 5 == 1) {
                strokeWeight(3);
            }else{
                strokeWeight(1);
            }
            line(0, y, width, y);
            lineNumber++;
        }
    }

    public void drawDotPaper(int gap, int radius) {
        // TODO: Finish this method.
        stroke(230,30,100);

        for (int x = 0; x < width; x+= gap) {
            for (int y = 0; y < height; y += gap) {
                ellipse(x,y,2*radius, 2*radius);
            }

        }






    }

    public void drawPrettyPaper() {
        for (int  x = 0; x < width; x++){
            for (int y = 0; y < height; y ++){
                int chosenColor = color((float) x/ width *360,(float) y/ height *100, 100);
                set(x,y,chosenColor);
        }
        // TODO: Finish this method.
    }}


    // Below here should be left alone. //

    public void menu() {
        int radius = 20;
        int spacer = width / 6;
        int startY = radius / 2 + 10;

        noStroke();
        PaperStyle[] styles = PaperStyle.values();
        for (int item = 1; item < 6; item++) {
            fill(item * 50, 100, 100);
            ellipse(spacer * item, startY, radius, radius);

            if (dist(mouseX, mouseY, spacer * item, startY) < radius) {
                paperMode = styles[item - 1];
            }
        }
    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
