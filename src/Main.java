import game.StartFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //确保所有 UI 操作都在事件调度线程中执行
        SwingUtilities.invokeLater(() -> {
            try {
                new StartFrame().setTitle("跑酷小游戏");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
