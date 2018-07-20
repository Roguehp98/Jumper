package Game.Cloud;

import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;

import java.util.Random;

public class CreateCould extends GameObject {
    FrameCounter frameCounter;

    private Random random = new Random();
    int zoneCloud;
    int a;
    int countCloud;
    int location;
    Vector2D loadLocationCloudBefore;


    public CreateCould(){
        this.frameCounter = new FrameCounter(40);
        loadLocationCloudBefore = new Vector2D();

    }
    public void run(){
        if(this.frameCounter.run()){
            Cloud cloud = new Cloud();
            GameObjectManager.instance.add(cloud);
            cloud.velocity.set(new Vector2D(0,1));
            countCloud = GameObjectManager.instance.countCloud();
            this.zoneCloud = random.nextInt(2);
            if(countCloud == 1){
                randomLocarion();
                cloud.position.set(CloudSteady.
                        loadLocationCloudSteady.
                        subtractBy(location * random.nextInt(108), random.nextInt(80)));
                // 108 : quang duong xa nhat player nhay duoc
                // 80 : do cao cao nhat player dvuon toi
                this.loadLocationCloudBefore.set(cloud.position.copy());
                }
            else {
                randomLocarion();
                cloud.position
                        .set(this.loadLocationCloudBefore
                        .subtractBy(location * random.nextInt(108),random.nextInt(80)));
                this.loadLocationCloudBefore.set(cloud.position.copy());
            }

//            System.out.println(zoneCloud);
//            a = random.nextInt(200);
////            System.out.println(a);
////            System.out.println("------");
//            switch (zoneCloud){
//                case 0:
//                    cloud.position.set(a,0);
//                    break;
//                case 1:
//                    cloud.position.set(200 + a,0);
//                    break;
//                case 2:
//                    cloud.position.set(400 + a,0);
//                    break;
//            }


            this.frameCounter.reset();
        }
    }

    public void randomLocarion(){
        switch (this.zoneCloud) {
            case 0:
                location = -1;
                break;
            case 1:
                location = 1;
                break;
        }
    }
}
