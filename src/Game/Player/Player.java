package Game.Player;

import Base.GameObject;
import Base.Vector2D;
import Physic.BoxCollider;
import Renderer.ImageRenderer;


public class Player extends GameObject {

    public Vector2D velocity;

    public BoxCollider boxCollider;

    public Player(){
        this.renderer = new ImageRenderer("resource/circle.png",10,10);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);
        this.attributes.add(new PlayerMove());
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
    }
}
