package game;

import util.StaticValue;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Container container = this.getContentPane();

    public GameFrame() {
        setSize(StaticValue.WIDTH, StaticValue.HEIGHT);
        setTitle("跑酷小游戏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        if (StaticValue.level == 1)
            this.add(new GamePanel(() -> {
                SwingUtilities.invokeLater(() -> {
                    container.removeAll();
                    container.add(new GamePanel2());
                    container.revalidate();
                    container.repaint();
                    JOptionPane.showMessageDialog(this, "恭喜过关，欢迎来到第二关^_^");
                });
            }));
        else if (StaticValue.level == 2)
            this.add(new GamePanel2());
    }
}
