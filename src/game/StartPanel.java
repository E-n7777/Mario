package game;

import util.StaticValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * description ： 首页的 Panel
 * date : 2025/2/27 16:26
 */
public class StartPanel extends JPanel implements KeyListener {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Toolkit.getDefaultToolkit()
                        .getImage("src/image/scene/bg_Start.jpg")
                , 0, 0, getWidth(), getHeight(), this);
    }

    public StartPanel() {
        setLayout(null);
        setFocusable(true);
        addKeyListener(this);
        setPreferredSize(new Dimension(StaticValue.WIDTH, StaticValue.HEIGHT));
        //历史分数
        JLabel history = new JLabel("历史最高分为: " + StaticValue.history);
        history.setFont(new Font("Serif", Font.BOLD, 24));
        history.setBounds(250, 300, 200, 30);
        add(history);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.setVisible(false);
            SwingUtilities.invokeLater(() -> {
                try {
                    new GameFrame();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
