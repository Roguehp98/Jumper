package Game.Player;

import Base.GameObject;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyPlatformBullet;
import Game.Enemy.EnemyFly.EnemySin;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;


public class Player extends GameObject implements PhysicBody {

    public Vector2D velocity;

    public BoxCollider boxCollider;
    public static boolean changeVelocity = false;

    private RunHitObj runHitObj;

    public Player(){
        this.renderer = new ImageRenderer("resource/image/circle.png",16,16);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(16,16);
        this.attributes.add(new PlayerMove());
        this.attributes.add(new PlayerShoot());
        this.runHitObj = new RunHitObj(
                EnemyPlatformBullet.class,
                EnemySin.class
        );
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 8, this.position.y - 8);
//        runHitObj.run(this);

    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
            if(gameObject instanceof EnemyPlatformBullet)
                this.isAlive = false;
            if(gameObject instanceof EnemySin)
                this.isAlive = false;
    }

}
