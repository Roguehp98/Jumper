package Game.Enemy.EnemyFly;

import Base.FrameCounter;
import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyPlatformBullet;
import Scene.GamePlayScene;
import Scene.SceneManager;

public class EnemySinShoot implements GameObjectAttributes<EnemySin> {
    private FrameCounter frameCounter;
    private EnemyRage enemyRage;

    public EnemySinShoot() {
        this.frameCounter = new FrameCounter(90);
        this.enemyRage = new EnemyRage();
    }

    @Override
    public void run(EnemySin gameObject) {
        if (SceneManager.instance.getCurrentScene() instanceof GamePlayScene)
            if (this.frameCounter.run() && EnemySin.distanceBetweenPlayerAndEnemySin < 100) {
                this.enemyRage.run(gameObject);
                this.frameCounter.reset();
            } else if (frameCounter.run()) {
                EnemyPlatformBullet enemyPlatformBullet = GameObjectManager.instance.recycle(EnemyPlatformBullet.class);
                enemyPlatformBullet.position.set(gameObject.position);
                enemyPlatformBullet.velocity.set(new Vector2D(0, 2));
                frameCounter.reset();
            }
    }
}
