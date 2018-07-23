package Game.Player;

import Base.GameObject;
import Base.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class PlayerBullet extends GameObject implements PhysicBody {
    BoxCollider boxCollider;
    Vector2D velocity;

    public PlayerBullet(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/circle.png",6,6);
        this.boxCollider = new BoxCollider(6,6);
    }

    @Override
    public void run(){
        super.run();
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
