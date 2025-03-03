package util;

import bean.Brick;
import bean.Coin;
import bean.Flower;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * description ： 一些游戏数据
 * date : 2025/2/27 14:06
 */
public class StaticValue {
    public static final int WIDTH = 750;
    public static final int HEIGHT = 500;
    public static final int MARIO_WIDTH = 25;
    public static final int MARIO_HEIGHT = 25;
    public static final int GROUND = 360;
    public static int mario_x = 15;
    public static int mario_y = 350;
    public static final int RUN_R = 800;
    public static final int RUN_L = 600;
    public static final int STAND_R = 400;
    public static final int STAND_L = 400;
    public static final int JUMP_R = 200;
    public static final int JUMP_L = 200;
    public static int level = 2;
    public static int score = 0;
    public static int health = 3;
    public static int history = 0;
    public static List<Brick> stairBricks = new ArrayList<>();
    public static List<Brick> platBricks = new ArrayList<>();
    public static List<Coin> coins = new CopyOnWriteArrayList<>();
    public static List<Flower> flowers = new ArrayList<>();
    public static List<JLabel> surprise = new CopyOnWriteArrayList<>();
}
