package Game.Enemy;

import Base.GameObject;
import Base.Vector2D;
import Game.Cloud.CloudJump;
import Game.Cloud.DriftingCloud;
import Game.Player.Player;
import Game.Player.PlayerBullet;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;

public class EnemyPlatformBullet extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public Vector2D velocity;
    private RunHitObj runHitObj;

    public EnemyPlatformBullet(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/circle.png",5,5);
        this.boxCollider = new BoxCollider(5,5);
        this.runHitObj = new RunHitObj(
                PlayerBullet.class,
                CloudJump.class,
                DriftingCloud.class,
                Player.class
        );
    }

    @Override
    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x - 2.5f, this.position.y - 2.5f);
        this.position.addUp(this.velocity);
        this.runHitObj.run(this);
    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof PlayerBullet)
            this.isAlive = false;
        if(gameObject instanceof CloudJump)
            this.isAlive = false;
        if(gameObject instanceof DriftingCloud)
            this.isAlive = false;
        if(gameObject instanceof Player)
            this.isAlive = false;
    }
}
