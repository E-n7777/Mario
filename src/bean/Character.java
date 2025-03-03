package bean;

import util.CharacterState;

import javax.swing.*;

import static util.StaticValue.*;

public class Character extends JLabel {
    private int blood;
    private boolean isJumping = false;
    private CharacterState state = CharacterState.STAND_R;

    public Character(Icon image) {
        super(image);
    }

    // 跳跃
    public void jump() {
        for (int i = 0; i < 30; i++) {
            mario_y -= 6;
            this.setBounds(mario_x, mario_y, MARIO_WIDTH, MARIO_HEIGHT);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 30; i++) {
            mario_y += 6;
            this.setBounds(mario_x, mario_y, MARIO_WIDTH, MARIO_HEIGHT);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isJumping = false;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public CharacterState getState() {
        return state;
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }
}
