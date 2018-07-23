package Game.Cloud;

import Action.*;
import Base.*;
import Game.Enemy.EnemyPlatform;

import java.util.Random;

public class CreateDriftingCloud extends GameObject  {
    FrameCounter frameCounter;

    private Random random = new Random();
    int zoneCloud;
    int a;



    public CreateDriftingCloud(){
        this.frameCounter = new FrameCounter(150);
    }

    public void configAction(){
        this.addAction(
                new RepeatActionForever(
                        new SequenceAction(
                                new WaitAction(400),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        DriftingCloud driftingCloud = GameObjectManager.instance.recycle(DriftingCloud.class);
                                        positionDriftingCloud(driftingCloud);
                                        driftingCloud.velocity.set(0,1);
                                        EnemyPlatform enemyPlatform = GameObjectManager.instance.recycle(EnemyPlatform.class);
                                        enemyPlatform.position.set(driftingCloud.position.x,driftingCloud.position.y - 25);
                                        outSreen(driftingCloud);
                                        if(!driftingCloud.isAlive){
                                            enemyPlatform.isAlive = false;
                                        }
                                        return true;
                                    }
                                }
                        )
                )
        );

    }

    public void positionDriftingCloud(DriftingCloud driftingCloud){
        this.zoneCloud = random.nextInt(2);
        if(this.zoneCloud == 1){
            driftingCloud.position.set(random.nextInt(70),0);
        }
        if(this.zoneCloud == 0){
            a = random.nextInt(50);
            driftingCloud.position.set(new Vector2D(400 + a,0));
        }
    }

    public void outSreen(DriftingCloud driftingCloud){
        if(driftingCloud.position.y > 800){
            driftingCloud.isAlive = false;
        }
    }
}
