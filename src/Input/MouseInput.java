package Input;

import Scene.GamePlayScene;
import Scene.GameStartScene;
import Scene.SceneManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println(e.getX() + ", " + e.getY());
        if (SceneManager.instance.getCurrentScene() instanceof GameStartScene)
            if (e.getX() > 94 && e.getX() < 377 && e.getY() > 513 && e.getY() < 767) {
                SceneManager.instance.changeScene(new GamePlayScene());
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
