package Game.Enemy.EnemyJump;

import Base.GameObject;
import Base.Vector2D;
import Game.Player.Player;
import Game.Player.PlayerBullet;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;
import Scene.GameStartScene;
import Scene.SceneManager;

public class EnemyPlatform extends GameObject implements PhysicBody {
    Vector2D velocity;
    private RunHitObj runHitObj;
    BoxCollider boxCollider;
    public EnemyPlatform(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/image/Character/EnemyJump.png",30,30);
        this.boxCollider = new BoxCollider(30,30);
        this.attributes.add(new EnemyPlatformMove());
        this.attributes.add(new EnemyShoot());
        this.runHitObj = new RunHitObj(PlayerBullet.class,
                Player.class);
    }

    @Override
    public void run() {
        super.run();
        if(SceneManager.instance.getCurrentScene() instanceof GameStartScene) {
            this.renderer = new ImageRenderer("resource/image/Character/EnemyJump.png", 60, 60);
            this.boxCollider = new BoxCollider(60, 60);
            this.boxCollider.position.set(this.position.x - 30, this.position.y - 30);
        }else {
            this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
        }
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
        if(gameObject instanceof Player)
            this.isAlive = false;
    }
}
