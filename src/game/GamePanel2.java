package game;

import bean.Brick;
import bean.Character;
import util.StaticValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static util.Creat.*;
import static util.StaticValue.*;

/**
 * description ： 第二关的游戏面板
 * date : 2025/3/1 17:40
 */
public class GamePanel2 extends JLayeredPane implements Runnable {
    private Character character;
    private JLabel scoreLabel;
    private JLabel healthLabel;

    public GamePanel2() {
        //绝对布局
        setLayout(null);
        //面板获得焦点
        setFocusable(true);
        addKeyListener(new TwoListener());

        initGame();
    }

    private void initGame() {
        //人物初始化
        character = new Character(new ImageIcon("src/image/mario/stand_R.png"));
        character.setFont(new Font("隶书", Font.BOLD, 30));
        character.setBounds(mario_x, mario_y, MARIO_WIDTH, MARIO_HEIGHT);
        character.setLayout(null);
        add(character);

        //食人花初始化
        add(createFlower(100, GROUND));
        add(createFlower(320, GROUND));
        // 初始化金币
        add(createCoin(400, 210));
        add(createCoin(350, GROUND));
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
        createStairs(480, GROUND, 20, 20, 5);
        for (Brick b : StaticValue.stairBricks)
            add(b);
    }

    private class TwoListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                mario_x -= 10;
            } else if (key == KeyEvent.VK_RIGHT) {
                mario_x += 10;
            } else if (key == KeyEvent.VK_UP) {
                if (!character.isJumping()) {
                    character.setJumping(true);
                    new Thread(() -> character.jump()).start();
                }
            }
            // 更新马里奥的位置
            character.setBounds(mario_x, mario_y, MARIO_WIDTH, MARIO_HEIGHT);

            // 检查是否吃到金币
            for (int i = 0; i < coins.size(); i++) {
                JLabel coin = coins.get(i);
                if (character.getBounds().intersects(coin.getBounds())) {
                    remove(coin); // 移除金币
                    coins.remove(i);
                    score += 10;
                    scoreLabel.setText("分数: " + score);
                    break;
                }
                gameOver();
            }

            // 检查是否碰到食人花
            for (JLabel flower : flowers) {
                if (character.getBounds().intersects(flower.getBounds())) {
                    health--;
                    healthLabel.setText("生命值: " + health);
                    if (health <= 0) {
                        gameOver();
                    }
                    break;
                }
            }

            // 检查是否碰到 ? 方块
            for (JLabel block : surprise) {
                if (character.getBounds().intersects(block.getBounds())) {
                    block.setText(""); // 清空惊喜方块的文字 ?
                    surprise.remove(block);
                    add(createCoin(block.getX() + 10, block.getY() - 20)); // 在惊喜方块上方生成金币
                    break;
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private void gameOver() {
        System.out.println(coins.size());
        if (health <= 0) {
            JOptionPane.showMessageDialog(this, "诶呀，死掉了TAT\n本轮分数是：" + score);
            System.exit(0);
        }
        if (coins.isEmpty()) {
            JOptionPane.showMessageDialog(this, "very Newberry!\n恭喜泥已经巴所有金币吃掉喽，解锁最高分：" + score);
            System.exit(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Toolkit.getDefaultToolkit()
                        .getImage("src/image/scene/bg_2.jpg")
                , 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
