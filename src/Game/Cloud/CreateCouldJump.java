package Game.Cloud;

import Action.*;
import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;

import java.util.Random;

public class CreateCouldJump extends GameObject {
    FrameCounter frameCounter;

    private Random random = new Random();
    int zoneCloud;
    int countCloud;
    int location;
    Vector2D loadLocationCloudBefore;


    public CreateCouldJump() {
        this.frameCounter = new FrameCounter(40);
        loadLocationCloudBefore = new Vector2D();

    }

    public void configAction() {
//        if(this.frameCounter.run()){
//            CloudJump cloudJump = GameObjectManager.instance.recycle(CloudJump.class);
////            GameObjectManager.instance.add(cloudJump);
//            cloudJump.velocity.set(new Vector2D(0,1));
//            countCloud = GameObjectManager.instance.countCloud();
//            positionCloudJump(cloudJump);
//            this.frameCounter.reset();
//        }

        this.addAction(
                new RepeatActionForever(
                        new SequenceAction(
                                new WaitAction(50),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        CloudJump cloudJump = GameObjectManager.instance.recycle(CloudJump.class);
                                        countCloud = GameObjectManager.instance.countCloud();
                                        positionCloudJump(cloudJump);
                                        return true;
                                    }
                                }
                        )
                )
        );

    }

    public void randomLocaion() {
        switch (this.zoneCloud) {
            case 0:
                location = -1;
                break;
            case 1:
                location = 1;
                break;
        }
    }

    public void positionCloudJump(CloudJump cloudJump) {
        this.zoneCloud = random.nextInt(2);
        if (countCloud == 1) {
            randomLocaion();

            cloudJump.position.x = CloudSteady.loadLocationCloudSteady.x - location * random.nextInt(108);

            cloudJump.position.y = 0;
            // 108 : quang duong xa nhat player nhay duoc
            // 80 : do cao cao nhat player vuon toi
            this.loadLocationCloudBefore.set(cloudJump.position.copy());
        } else {
            randomLocaion();
            cloudJump.position.x = this.loadLocationCloudBefore.x - location * random.nextInt(108) - location * 30;
            if (cloudJump.position.x < 70 || cloudJump.position.x > 400) {
                cloudJump.position.x = this.loadLocationCloudBefore.x - (-1) * location * random.nextInt(108);
            }
            cloudJump.position.y = this.loadLocationCloudBefore.y - 45 ;
            this.loadLocationCloudBefore.set(cloudJump.position.copy());
        }
    }

}
