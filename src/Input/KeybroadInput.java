package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeybroadInput implements KeyListener {
    public static KeybroadInput instance = new KeybroadInput();

    public boolean isRight = false;
    public boolean isLeft = false;
    public int countTime = 5;

    private KeybroadInput(){

    }
    public void reset(){
        this.countTime = 1;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.isRight = true;
            }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.isLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.isRight = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                this.isLeft = false;
            }
    }
}
