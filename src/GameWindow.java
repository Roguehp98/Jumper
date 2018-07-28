import Input.KeybroadInput;
import Input.MouseInput;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTime;

    public GameWindow() {
        this.setSize(450, 800);
        gameCanvas = new GameCanvas();
        this.add(gameCanvas);
        this.event();
        this.setVisible(true);
    }

    private void event(){
        mouseEvent();
        keyboardEvent();
        windowEvent();
    }

    private void mouseEvent(){
        this.addMouseListener(new MouseInput());
    }

    private void keyboardEvent() {
        this.addKeyListener(KeybroadInput.instance);
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                gameCanvas.renderAll();
                gameCanvas.runAll();
                this.lastTime = currentTime;
            }
        }
    }
}
