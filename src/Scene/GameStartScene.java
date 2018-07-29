package Scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Game.Background.BackGroundStart;
import Game.Background.Background;
import Game.Background.ButtonStart;
import Game.Background.DrawTextStart;
import Game.Cloud.CloudSteadyStart;
import Game.Enemy.EnemyFly.EnemySin;
import Game.Enemy.EnemyJump.EnemyPlatform;
import Game.Player.Player;

public class GameStartScene implements Scene {


    @Override
    public void init() {

        BackGroundStart backGroundStart = GameObjectManager.instance.recycle(BackGroundStart.class);
        GameObjectManager.instance.add(new EnemySin(0,400));
    }

    public void setupPlayer() {
        Player player = new Player();
        player.position.set(new Vector2D(350, 500));
        GameObjectManager.instance.add(player);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
