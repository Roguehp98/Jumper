package Game.Player;

import Base.GameObject;
import Base.Vector2D;
import Game.Cloud.CloudJump;
import Game.Cloud.DriftingCloud;
import Game.Enemy.EnemyPlatform;
import Game.Enemy.EnemyPlatformBullet;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;

public class PlayerBullet extends GameObject implements PhysicBody {
    BoxCollider boxCollider;
    Vector2D velocity;
    private RunHitObj runHitObj;

    public PlayerBullet(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/circle.png",6,6);
        this.boxCollider = new BoxCollider(6,6);
        this.runHitObj = new RunHitObj(
                CloudJump.class,
                DriftingCloud.class,
                EnemyPlatformBullet.class,
                EnemyPlatform.class
        );
    }

    @Override
    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x - 3,this.position.y - 3);
        this.position.addUp(this.velocity);
        this.runHitObj.run(this);
    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof CloudJump || gameObject instanceof DriftingCloud)
            this.isAlive = false;
        if(gameObject instanceof EnemyPlatformBullet)
            this.isAlive = false;
        if(gameObject instanceof EnemyPlatform)
            this.isAlive = false;
    }
}
