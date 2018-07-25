package Game.Cloud;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Player.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class CloudJump extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    public Vector2D velocity;
    int zoneCloud;
    int location;

    Random random = new Random();

    public CloudJump() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/cloud.png", 50, 20);
        this.boxCollider = new BoxCollider(50, 1);
//        this.runHitObj = new RunHitObj(Player.class);
    }

    public void run() {
        super.run();
        this.velocity.set(new Vector2D(0, 1));
        Player player = GameObjectManager.instance.findObject(Player.class);
        if (player != null)
            if (player.velocity.y > 0) {
//            this.boxCollider = new BoxCollider(50,1);
                this.boxCollider.position.set(this.position.x - 25, this.position.y + 10);
            } else {
//            this.boxCollider = new BoxCollider(50,1);
                this.boxCollider.position.set(this.position.x - 25, this.position.y - 10);
            }
        this.position.addUp(this.velocity);
        this.outSreen();

    }

    public void outSreen() {
        if (this.position.y > 800 ) {
            this.position.y = 0;
        }
    }

    public void resetPositionX(){
        this.zoneCloud = random.nextInt(2);
        randomLocaion();
        this.position.x = CreateCouldJump.loadLocationCloudBefore.x - location * random.nextInt(108) - location * 10;
        if (this.position.x < 90 || this.position.x > 350) {
            this.position.x = CreateCouldJump.loadLocationCloudBefore.x - (-1) * location * random.nextInt(108) + location*10;
        }
        CreateCouldJump.loadLocationCloudBefore.set(this.position.copy());
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

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
