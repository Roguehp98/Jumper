package Game.Enemy.EnemyJump;

import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Game.Cloud.CloudSteadyStart;
import Game.Cloud.DriftingCloud;
import Scene.GamePlayScene;
import Scene.GameStartScene;
import Scene.SceneManager;

public class EnemyPlatformMove implements GameObjectAttributes<EnemyPlatform> {
    float velocity = 1;
    float gravity = 0.3f;
    public EnemyPlatformMove(){

    }
    @Override
    public void run(EnemyPlatform enemyPlatform) {
        DriftingCloud driftingCloud = GameObjectManager.instance.checkCollision(enemyPlatform.boxCollider, DriftingCloud.class);
        CloudSteadyStart cloudSteadyStart = GameObjectManager.instance.checkCollision(enemyPlatform.boxCollider, CloudSteadyStart.class);
        if(velocity < 0){
            if(driftingCloud != null || cloudSteadyStart != null){
                if(SceneManager.instance.getCurrentScene() instanceof GamePlayScene)
                    velocity = 4;
                if(SceneManager.instance.getCurrentScene() instanceof GameStartScene)
                    velocity = 7;
            }
        }
        this.velocity -= gravity;
        enemyPlatform.velocity.set(0,this.velocity);
        enemyPlatform.position.subtractBy(enemyPlatform.velocity);
    }

}
