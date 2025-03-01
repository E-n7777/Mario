package game;

import bean.Brick;
import bean.Character;
import util.StaticValue;

import javax.swing.*;
import java.awt.*;

import static util.Creat.*;

/**
 * description ： 第二关的游戏面板
 * date : 2025/3/1 17:40
 */
public class GamePanel2 extends JLayeredPane {
    private Character marioLabel; // 马里奥的 JLabel
    private int score = 0; // 分数显示
    private int health = 3; // 生命值显示
    private JLabel scoreLabel;
    private JLabel healthLabel;

    public GamePanel2() {
        //绝对布局
        setLayout(null);
        //面板获得焦点
        setFocusable(true);

        //人物初始化
        marioLabel = new Character("人");
        marioLabel.setFont(new Font("隶书", Font.BOLD, 30));
        marioLabel.setBounds(15, 340, 50, 50);
        marioLabel.setLayout(null);
        add(marioLabel);

        //食人花初始化
        add(createFlower(100, 350));
        add(createFlower(320, 350));
        // 初始化金币
        add(createCoin(400, 210));
        add(createCoin(350, 350));
        add(createCoin(560, 250));

        // 初始化分数和生命值显示
        scoreLabel = new JLabel("分数: " + score);
        scoreLabel.setFont(new Font("方正舒体", Font.BOLD, 20));
        scoreLabel.setBounds(15, 20, 100, 20);
        add(scoreLabel);

        healthLabel = new JLabel("生命值: " + health);
        healthLabel.setFont(new Font("方正舒体", Font.BOLD, 20));
        healthLabel.setBounds(15, 55, 100, 20);
        add(healthLabel);

        // 初始化惊喜方块
        add(createSurprise(290, 230));
        add(createSurprise(210, 300));

        //初始化平台
        createPlat(170, 300, 20, 20, 2);
        createPlat(230, 300, 20, 20, 4);
        createPlat(310, 230, 20, 20, 5);
        for (Brick b : StaticValue.platBricks)
            add(b);

        //初始化楼梯
        createStairs(480, 350, 20, 20, 5);
        for (Brick b : StaticValue.stairBricks)
            add(b);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Toolkit.getDefaultToolkit()
                        .getImage("E://重邮课程//实训//大二//Mario//src//image//scene//bg_2.jpg")
                , 0, 0, getWidth(), getHeight(), this);
    }
}
