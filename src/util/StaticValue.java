package util;

import bean.Brick;
import bean.Coin;
import bean.Flower;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * description ： 一些常量
 * date : 2025/2/27 14:06
 */
public class StaticValue {
    public static final int WIDTH = 750;
    public static final int HEIGHT = 500;
    public static final int RUN_R = 800;
    public static final int RUN_L = 600;
    public static final int STAND_R = 400;
    public static final int STAND_L = 400;
    public static final int JUMP_R = 200;
    public static final int JUMP_L = 200;
    public static int LEVEL = 1;
    public static List<Brick> stairBricks = new ArrayList<>();
    public static List<Brick> platBricks = new ArrayList<>();
    public static List<Coin> coins = new ArrayList<>();
    public static List<Flower> flowers = new ArrayList<>();
    public static List<JLabel> surprise = new ArrayList<>();
}
