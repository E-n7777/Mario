package util;

import bean.Brick;
import bean.Coin;
import bean.Flower;

import javax.swing.*;
import java.awt.*;

/**
 * description ：用于场景创造
 * date : 2025/3/1 16:26
 */
public class Creat {
    // 创建金币
    public static Coin createCoin(int x, int y) {
        Coin coin = new Coin("$");
        coin.setFont(new Font("华文行楷", Font.ITALIC, 15));
        coin.setBounds(x, y, 20, 20);
        StaticValue.coins.add(coin);
        return coin;
    }

    // 创建食人花
    public static Flower createFlower(int x, int y) {
        Flower flower = new Flower("花", FlowerState.CLOSE);
        flower.setFont(new Font("华文行楷", Font.PLAIN, 18));
        flower.setBounds(x, y, 20, 20);
        StaticValue.flowers.add(flower);
        return flower;
    }

    // 创建惊喜方块
    public static JLabel createSurprise(int x, int y) {
        JLabel surprise = new JLabel("?", SwingConstants.CENTER);
        surprise.setOpaque(true);
        surprise.setBackground(Color.YELLOW);
        surprise.setBounds(x, y, 20, 20);
        StaticValue.surprise.add(surprise);
        return surprise;
    }

    // 创建砖块
    public static Brick createBrick(int x, int y) {
        Brick brick = new Brick("砖", SwingConstants.CENTER);
        brick.setOpaque(true);
        brick.setBackground(Color.LIGHT_GRAY);
        brick.setBounds(x, y, 20, 20);
        return brick;
    }

    // 创建砖块楼梯
    public static void createStairs(int startX, int startY, int brickWidth, int brickHeight, int numStair) {
        for (int i = 0; i < numStair; i++) {
            for(int j = 0; j <= i; j++){
                Brick brick = new Brick("砖", SwingConstants.CENTER);
                brick.setOpaque(true);
                brick.setBackground(Color.LIGHT_GRAY);
                brick.setBounds(startX + i * brickWidth, startY - j * brickHeight, brickWidth, brickHeight);
                StaticValue.stairBricks.add(brick);
            }
        }
    }

    // 创建砖块平台
    public static void createPlat(int startX, int startY, int brickWidth, int brickHeight, int numBricks) {
        for (int i = 0; i < numBricks; i++) {
            Brick brick = new Brick("砖", SwingConstants.CENTER);
            brick.setOpaque(true);
            brick.setBackground(Color.LIGHT_GRAY);
            brick.setBounds(startX + i * brickWidth, startY, brickWidth, brickHeight);
            StaticValue.platBricks.add(brick);
        }
    }
}
