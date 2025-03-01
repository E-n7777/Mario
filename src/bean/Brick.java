package bean;

import java.awt.*;

/**
 * description ： 砖头类
 * date : 2025/2/26 22:15
 */
public class Brick extends Obstacle {
    public Brick(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    public Brick(String text) {
        super(text);
    }
}
