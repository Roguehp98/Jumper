package Highscore;

import Base.GameObject;
import Renderer.TextRenderer;
import Scene.GamePlayScene;
import Scene.GameOverScene;
import Scene.GameStartScene;
import Scene.SceneManager;

import java.awt.*;

public class Score extends GameObject {
    public static int score = 0;

    public Score(){
        this.renderer = new TextRenderer(
                "Score:  " + score,
                Color.RED,
                ".VnCourier New",
                30
        );
    }

    public void run(){
        if( SceneManager.instance.getCurrentScene() instanceof GameOverScene){
            score = 0;
        }
    }

}
