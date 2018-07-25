package Game.Enemy.EnemyFly;

import Base.FrameCounter;
import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyPlatformBullet;

public class EnemyThrow implements GameObjectAttributes<EnemySin> {
    FrameCounter frameCounter;

    public EnemyThrow(){
        this.frameCounter = new FrameCounter(90);
    }
    @Override
    public void run(EnemySin gameObject) {
        if(this.frameCounter.run()){
            EnemyPlatformBullet enemyPlatformBullet = GameObjectManager.instance.recycle(EnemyPlatformBullet.class);
            enemyPlatformBullet.position.set(gameObject.position);
            enemyPlatformBullet.velocity.set(new Vector2D(0,2));
            this.frameCounter.reset();
        }
    }
}
