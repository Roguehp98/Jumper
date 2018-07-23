package Game.Enemy;

import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Game.Cloud.DriftingCloud;

public class EnemyPlatformMove implements GameObjectAttributes<EnemyPlatform> {
    float velocity = 1;
    float gravity = 0.3f;
    public EnemyPlatformMove(){

    }
    @Override
    public void run(EnemyPlatform enemyPlatform) {
        DriftingCloud driftingCloud = GameObjectManager.instance.checkCollision(enemyPlatform.boxCollider, DriftingCloud.class);
        if(velocity < 0){
            if(driftingCloud != null){
                velocity = 4;
            }
        }
        this.velocity -= gravity;
        enemyPlatform.velocity.set(0,this.velocity);
        enemyPlatform.position.subtractBy(enemyPlatform.velocity);
        outSreen(enemyPlatform);
    }

    public void outSreen(EnemyPlatform enemyPlatform){
        if(enemyPlatform.position.y > 800)
            enemyPlatform.isAlive = false;
    }
}
