package bean;

import util.FlowerState;

import javax.swing.*;
import java.awt.*;

public class Flower extends Obstacle {
    private FlowerState state;

    public Flower(String text,FlowerState state) {
        super(text);
        this.state = state;
    }

    public Flower(Icon image, FlowerState state) {
        super(image);
        this.state = state;
    }

    public FlowerState getState() {
        return state;
    }

    public void setState(FlowerState state) {
        this.state = state;
    }
}
