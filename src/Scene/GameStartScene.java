package Scene;

import Base.GameObjectManager;
import Base.Vector2D;
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
        GameObjectManager.instance.recycle(Background.class);
        ButtonStart buttonStart = GameObjectManager.instance.recycle(ButtonStart.class);
        buttonStart.position.set(200,300);
        DrawTextStart drawTextStart = GameObjectManager.instance.recycle(DrawTextStart.class);
        drawTextStart.position.set(200,200);
        CloudSteadyStart cloudSteadyStart1 = new CloudSteadyStart(350,600);
        GameObjectManager.instance.add(cloudSteadyStart1);
        EnemyPlatform enemyPlatform = GameObjectManager.instance.recycle(EnemyPlatform.class);
        enemyPlatform.position.set(100,500);
        CloudSteadyStart cloudSteadyStart2 = new CloudSteadyStart(100,600);
        GameObjectManager.instance.add(cloudSteadyStart2);
        setupPlayer();
        GameObjectManager.instance.add(new EnemySin(0,100));
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
