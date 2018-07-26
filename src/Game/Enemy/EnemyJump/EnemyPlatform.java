package Game.Enemy.EnemyJump;

import Base.GameObject;
import Base.Vector2D;
import Game.Player.PlayerBullet;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;

public class EnemyPlatform extends GameObject implements PhysicBody {
    Vector2D velocity;
    private RunHitObj runHitObj;
    BoxCollider boxCollider;
    public EnemyPlatform(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/image/star.png",30,30);
        this.boxCollider = new BoxCollider(30,30);
        this.attributes.add(new EnemyPlatformMove());
        this.attributes.add(new EnemyShoot());
        this.runHitObj = new RunHitObj(PlayerBullet.class);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 15,this.position.y - 15);
        this.runHitObj.run(this);
        outSrceen();
    }

    public void outSrceen(){
        if(this.position.y > 800)
            this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof PlayerBullet)
            this.isAlive = false;
    }
}
