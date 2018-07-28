package Scene;

import Base.GameObjectManager;
import Game.Background.Background;
import Game.Background.DrawTextEnd;

public class GameOverScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        DrawTextEnd drawTextEnd = GameObjectManager.instance.recycle(DrawTextEnd.class);
        drawTextEnd.position.set(100,400);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
