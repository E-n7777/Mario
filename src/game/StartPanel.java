package game;

import util.StaticValue;

import javax.swing.*;
import java.awt.*;

/**
 * description ： 首页的 Panel
 * date : 2025/2/27 16:26
 */
public class StartPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Toolkit.getDefaultToolkit()
                        .getImage("E://重邮课程//实训//大二//Mario//src//image//scene//bg_Start.jpg")
                , 0, 0, getWidth(), getHeight(), this);
    }

    public StartPanel() {
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(StaticValue.WIDTH, StaticValue.HEIGHT));
        //历史分数
        JLabel history = new JLabel("历史最高分为:");
        history.setFont(new Font("Serif", Font.BOLD, 24));
        history.setBounds(250, 300, 200, 30);
        add(history);
    }


}
