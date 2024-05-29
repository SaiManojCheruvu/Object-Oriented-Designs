package umbcs680.ColorAdjustment.Lambda;

import java.util.ArrayList;

public class Image {
    private int width;
    private int height;
    private ArrayList<ArrayList<Color>> pixels;

    public Image(int height, int width) {
        this.height = height;
        this.width = width;
        this.pixels = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            ArrayList<Color> row = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                row.add(null);
            }
            pixels.add(row);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setColor(int x, int y, Color color) {
        pixels.get(y).set(x, color);
    }

    public Color getColor(int x, int y) {
        return pixels.get(y).get(x);
    }
}
