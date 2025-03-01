package bean;

import util.FlowerState;

import java.awt.*;

public class Flower extends Obstacle {
    private FlowerState state;

    public Flower(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    public Flower(String text,FlowerState state) {
        super(text);
        this.state = state;
    }

    public Flower(String text) {
        super(text);
    }

    public FlowerState getState() {
        return state;
    }

    public void setState(FlowerState state) {
        this.state = state;
    }
}
