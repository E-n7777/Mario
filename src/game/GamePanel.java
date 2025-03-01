package game;

import bean.Character;

import javax.swing.*;
import java.awt.*;

import static util.Creat.*;

/**
 * description ： 第一关的游戏面板
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
        marioLabel.setFont(new Font("隶书", Font.BOLD, 30));
        marioLabel.setBounds(15, 340, 50, 50);
        marioLabel.setLayout(null);
        add(marioLabel);

        //食人花初始化
        add(createFlower(300, 350));
        add(createFlower(450, 350));
        // 初始化金币
        add(createCoin(200, 350));
        add(createCoin(500, 350));

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
        add(createSurprise(140, 300));
        add(createSurprise(280, 300));
        add(createSurprise(320, 300));
        add(createSurprise(300, 230));
        //初始化砖块
        add(createBrick(260,300));
        add(createBrick(300,300));
        add(createBrick(340,300));
        //启动游戏循环
        //new Thread(this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Toolkit.getDefaultToolkit()
                        .getImage("E://重邮课程//实训//大二//Mario//src//image//scene//bg_1.jpg")
                , 0, 0, getWidth(), getHeight(), this);
    }
}
