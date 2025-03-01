package bean;

import util.CharacterState;

import javax.swing.*;

public class Character extends JLabel {
    private int blood;
    private int mark = 0;
    private CharacterState state = CharacterState.STAND_R;

    public Character(String text) {
        super(text);
    }

    // 跳跃
    public void jump() {

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
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
}
