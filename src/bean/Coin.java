package bean;

import java.awt.*;

public class Coin extends Obstacle {
    public Coin(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    public Coin(String text) {
        super(text);
    }

    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
    }
}
