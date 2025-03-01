package game;

import util.StaticValue;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        this.setSize(StaticValue.WIDTH, StaticValue.HEIGHT);
        this.setTitle("跑酷小游戏");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        if (StaticValue.LEVEL == 1)
            this.add(new GamePanel());
        else if (StaticValue.LEVEL == 2)
            this.add(new GamePanel2());
    }

    public static void main(String[] args) throws Exception {
        //确保所有 UI 操作都在 EDT 中执行
        SwingUtilities.invokeLater(() -> {
            try {
                new GameFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
