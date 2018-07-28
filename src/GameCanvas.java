import Base.GameObjectManager;
import Input.KeybroadInput;
import Scene.GameOverScene;
import Scene.GamePlayScene;
import Scene.GameStartScene;
import Scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    Graphics graphics;
    BufferedImage backBuffered;

    public GameCanvas() {
        this.setSize(600, 800);
        setUpBackBuffered();
        this.setVisible(true);
        SceneManager.instance.changeScene(new GameStartScene());
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();

    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        if (SceneManager.instance.getCurrentScene() instanceof GameStartScene)
            if (KeybroadInput.instance.isEnter) {
                SceneManager.instance.changeScene(new GamePlayScene());
            }
        if (SceneManager.instance.getCurrentScene() instanceof GameOverScene)
            if (KeybroadInput.instance.isEnter) {
                SceneManager.instance.changeScene(new GamePlayScene());
            }
        SceneManager.instance.performChangeSceneIfNeeded();
    }

    public void setUpBackBuffered() {
        backBuffered = new BufferedImage(450, 800, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }


}
