package bean;

import javax.swing.*;

/**
 * description ： 砖头类
 * date : 2025/2/26 22:15
 */
public class Brick extends Obstacle {
    public Brick(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public Brick(Icon image) {
        super(image);
    }
}
