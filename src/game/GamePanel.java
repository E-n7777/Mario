package game;

import bean.Brick;
import bean.Character;
import bean.Coin;
import bean.Flower;
import util.FlowerState;
import util.StaticValue;

import javax.swing.*;
import java.awt.*;

/**
 * description ： 游戏面板类
 * date : 2025/2/26 15:21
 */
public class GamePanel extends JLayeredPane {
    private Character marioLabel; // 马里奥的 JLabel
    private int score = 0; // 分数显示
    private int health = 3; // 生命值显示
    private JLabel scoreLabel;
    private JLabel healthLabel;

    //游戏面板初始化
    public GamePanel() {
        //绝对布局
        setLayout(null);
        //面板获得焦点
        setFocusable(true);

        //人物初始化
        marioLabel = new Character("人");
        marioLabel.setFont(new Font("隶书", Font.BOLD, 25));
        marioLabel.setBounds(15, 330, 50, 50);
        marioLabel.setLayout(null);
        add(marioLabel);

        //食人花初始化
        createFlower(300, 350);
        // 初始化金币
        createCoin(200, 350);
        createCoin(400, 350);

        // 初始化分数和生命值显示
        scoreLabel = new JLabel("分数: " + score);
        scoreLabel.setFont(new Font("方正舒体", Font.BOLD, 20));
        scoreLabel.setBounds(15, 20, 100, 20);
        add(scoreLabel);

        healthLabel = new JLabel("生命值: " + health);
        healthLabel.setFont(new Font("方正舒体", Font.BOLD, 20));
        healthLabel.setBounds(15, 55, 100, 20);
        add(healthLabel);

        // 初始化 ? 方块
        createSurprise(150, 230);
        createSurprise(350, 230);

        createStairs(500, 300, 20, 20, 10);
        //启动游戏循环
        //new Thread(this).start();
    }

    // 创建金币
    private void createCoin(int x, int y) {
        Coin coin = new Coin("币");
        coin.setFont(new Font("华文行楷", Font.ITALIC, 15));
        coin.setBounds(x, y, 20, 20);
        StaticValue.coins.add(coin);
        add(coin);
    }

    // 创建食人花
    private void createFlower(int x, int y) {
        Flower flower = new Flower("花", FlowerState.CLOSE);
        flower.setFont(new Font("华文行楷", Font.PLAIN, 18));
        flower.setBounds(x, y, 20, 20);
        StaticValue.flowers.add(flower);
        add(flower);
    }

    // 创建惊喜方块
    private void createSurprise(int x, int y) {
        JLabel block = new JLabel("?", SwingConstants.CENTER);
        block.setOpaque(true);
        block.setBackground(Color.YELLOW);
        block.setBounds(x, y, 20, 20);
        StaticValue.surprise.add(block);
        add(block);
    }

    // 创建楼梯砖块
    private void createStairs(int startX, int startY, int brickWidth, int brickHeight, int numBricks) {
        for (int i = 0; i < numBricks; i++) {
            Brick brick = new Brick("砖");
            brick.setBounds(startX + i * brickWidth, startY - i * brickHeight, brickWidth, brickHeight);
            StaticValue.bricks.add(brick);
            add(brick);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Toolkit.getDefaultToolkit()
                        .getImage("E://重邮课程//实训//大二//Mario//src//image//scene//bg_1.jpg")
                , 0, 0, getWidth(), getHeight(), this);
    }
}
