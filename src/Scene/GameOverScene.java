package Scene;

import Base.GameObjectManager;
import Game.Background.BackGroundOver;
import Game.Background.Background;
import Game.Background.DrawTextEnd;
import Game.Background.DrawTextPlayagain;
import Highscore.Score;

public class GameOverScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(BackGroundOver.class);
        DrawTextEnd drawTextEnd = GameObjectManager.instance.recycle(DrawTextEnd.class);
        drawTextEnd.position.set(100,400);
        Score score = GameObjectManager.instance.recycle(Score.class);
        score.position.set(100,500);
        DrawTextPlayagain drawTextPlayagain =GameObjectManager.instance.recycle(DrawTextPlayagain.class);
        drawTextPlayagain.position.set(70,550);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
