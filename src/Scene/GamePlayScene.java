package Scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Game.Background.BackGroundOver;
import Game.Background.Background;
import Game.Cloud.CloudSteadyinGamePlay;
import Game.Cloud.CreateCouldJump;
import Game.Cloud.CreateDriftingCloud;
import Game.Enemy.EnemyFly.EnemySin;
import Game.Player.Player;

public class GamePlayScene implements Scene{

    @Override
    public void init() {
        this.setupCharacter();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

    public void setupCharacter() {
        CreateCouldJump createCouldJump = GameObjectManager.instance.recycle(CreateCouldJump.class);
        createCouldJump.configAction();
        CreateDriftingCloud createDriftingCloud = GameObjectManager.instance.recycle(CreateDriftingCloud.class);
        createDriftingCloud.configAction();
        GameObjectManager.instance.add(new BackGroundOver());
        GameObjectManager.instance.add(new CloudSteadyinGamePlay());
        GameObjectManager.instance.add(new EnemySin(0,200));
        this.setupPlayer();
    }

    public void setupPlayer() {
        Player player = new Player();
        player.position.set(new Vector2D(200, 350));
        GameObjectManager.instance.add(player);
    }

}
