package Game.Cloud;

import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;

import java.util.Random;

public class CreateDriftingCloud extends GameObject {
    FrameCounter frameCounter;

    private Random random = new Random();
    int zoneCloud;
    int a;



    public CreateDriftingCloud(){
        this.frameCounter = new FrameCounter(40);
    }
    public void run(){
        if(this.frameCounter.run()){
            DriftingCloud driftingCloud = GameObjectManager.instance.recycle(DriftingCloud.class);
//            GameObjectManager.instance.add(driftingCloud);
            driftingCloud.velocity.set(new Vector2D(0,1));
            positionDriftingCloud(driftingCloud);
            this.frameCounter.reset();
        }
    }

    public void positionDriftingCloud(DriftingCloud driftingCloud){
        this.zoneCloud = random.nextInt(2);
        if(this.zoneCloud == 1){
            driftingCloud.position.set(random.nextInt(200),0);
        }
        if(this.zoneCloud == 0){
            a = random.nextInt(200);
            driftingCloud.position.set(new Vector2D(400 + a,0));
        }
    }
    // Công việc ngày mai
    /* Sáng: recycle và action để cloud ra chậm hơn
        clean code phần va chạm
        Tối: Enemy chạy hình sin
        Double jump
     */
}
