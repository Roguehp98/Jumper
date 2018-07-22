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

    Random random = new Random();
    public CloudJump(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/cloud.png",50,20);
//        this.position.set(random.nextInt(400),800);
        this.boxCollider = new BoxCollider(50,20);
//        this.runHitObj = new RunHitObj(Player.class);
    }

    public void run(){
        super.run();
        this.velocity.set(new Vector2D(0,1));
        Player player = GameObjectManager.instance.findPlayer();
        if(player.velocity.y > 0 ){
            this.boxCollider = new BoxCollider(50,1);
            this.boxCollider.position.set(this.position.x - 25,this.position.y + 10);
        }else{
            this.boxCollider = new BoxCollider(50,1);
            this.boxCollider.position.set(this.position.x - 25, this.position.y - 10);
        }
        this.position.addUp(this.velocity);

    }


    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
