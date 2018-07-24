package Game.Enemy;

import Base.FrameCounter;
import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Base.Vector2D;


public class EnemyShoot implements GameObjectAttributes<EnemyPlatform> {
    FrameCounter frameCounter;

    public EnemyShoot() {
        this.frameCounter = new FrameCounter(180);
    }

    @Override
    public void run(EnemyPlatform gameObject) {
        if (this.frameCounter.run()) {
            if (gameObject.isAlive)
                for (double angle = 0.0; angle >= -180.0; angle -= 360.0 / 12.0) {
                    EnemyPlatformBullet enemyPlatformBullet = GameObjectManager.instance.recycle(EnemyPlatformBullet.class);
                    enemyPlatformBullet.position.set(gameObject.position);
                    enemyPlatformBullet.velocity.set(
                            (new Vector2D(2.0f, 0.0f)).rotate(angle)
                    );
                    outScreen(enemyPlatformBullet);
                    this.frameCounter.reset();
                }
        }
    }

    public void outScreen(EnemyPlatformBullet enemyPlatformBullet){
        if(enemyPlatformBullet.position.x < 0
                || enemyPlatformBullet.position.x > 480
                || enemyPlatformBullet.position.y < 0
                || enemyPlatformBullet.position.y > 800)
            enemyPlatformBullet.isAlive = false;
    }
}
