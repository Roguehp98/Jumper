package Game.Cloud;

import Base.GameObject;
import Base.Vector2D;
import Physic.BoxCollider;
import Renderer.ImageRenderer;

import java.util.Random;

public class DriftingCloud extends GameObject {

    public BoxCollider boxCollider;
    public Vector2D velocity;

    Random random = new Random();
    public DriftingCloud(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/cloud.png",50,20);
        this.boxCollider = new BoxCollider(50,20);

    }

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
    }

}
