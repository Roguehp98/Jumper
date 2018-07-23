package Game.Enemy;

import Base.GameObject;
import Base.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class EnemyPlatformBullet extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public Vector2D velocity;

    public EnemyPlatformBullet(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/circle.png",5,5);
        this.boxCollider = new BoxCollider(5,5);
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
