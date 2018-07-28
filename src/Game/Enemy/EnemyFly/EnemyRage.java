package Game.Enemy.EnemyFly;

import Base.FrameCounter;
import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyPlatformBullet;

public class EnemyRage {

    public EnemyRage(){
    }


    public void run(EnemySin enemySin) {
        for (double angle = 0.0; angle >= -360.0; angle -= 360.0 / 12.0) {
            EnemyPlatformBullet enemyPlatformBullet = GameObjectManager.instance.recycle(EnemyPlatformBullet.class);
            enemyPlatformBullet.position.set(enemySin.position);
            enemyPlatformBullet.velocity.set(
                    (new Vector2D(2.0f, 0.0f)).rotate(angle)
            );
        }
    }

}
