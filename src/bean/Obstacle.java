package bean;

import javax.swing.*;
import java.awt.*;

/**
 * description ： 所有障碍物的父类，设置为抽象类，必须有子类实现
 * date : 2025/2/26 22:13
 */
public abstract class Obstacle extends JLabel {
    public int x,y;
    public int width,height;
    public Image img;
    public Obstacle(int x, int y, int width, int height,Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img=img;
    }

    public Obstacle(String text) {
        super(text);
    }

    public Obstacle(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public Obstacle(String text, int x, int y) {
        super(text);
        this.x = x;
        this.y = y;
    }
}
