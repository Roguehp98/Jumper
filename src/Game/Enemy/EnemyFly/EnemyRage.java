package Game.Enemy.EnemyFly;

import Base.FrameCounter;
import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyPlatformBullet;

public class EnemyRage implements GameObjectAttributes<EnemySin> {

    FrameCounter frameCounter;
    public EnemyRage(){
        this.frameCounter = new FrameCounter(60);
    }
    @Override
    public void run(EnemySin gameObject) {
        if (gameObject.isAlive)
            for (double angle = 0.0; angle >= -360.0; angle -= 360.0 / 12.0) {
                EnemyPlatformBullet enemyPlatformBullet = GameObjectManager.instance.recycle(EnemyPlatformBullet.class);
                enemyPlatformBullet.position.set(gameObject.position);
                enemyPlatformBullet.velocity.set(
                        (new Vector2D(2.0f, 0.0f)).rotate(angle)
                );
                this.frameCounter.reset();
            }
    }
}
