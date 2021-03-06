package Game.Cloud;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyPlatformBullet;
import Game.Player.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;

import java.util.Random;

public class DriftingCloud extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    public Vector2D velocity;

    Random random = new Random();
    private RunHitObj runHitObj = new RunHitObj(EnemyPlatformBullet.class);

    public DriftingCloud() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/image/cloud.png", 50, 20);
        this.boxCollider = new BoxCollider(50, 1);
    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        Player player = GameObjectManager.instance.findObject(Player.class);
        if (player != null) {
            if (player.velocity.y > 0) {
//                this.boxCollider = new BoxCollider(50, 1);
                this.boxCollider.position.set(this.position.x - 25, this.position.y + 10);
            } else {
                this.boxCollider.position.set(this.position.x - 25, this.position.y - 10);
            }
        }
        else this.boxCollider.position.set(this.position.x - 25,this.position.y  - 10);
        this.runHitObj.run(this);
        outSreen();
    }

    public void outSreen() {
        if (this.position.y > 800) {
            this.isAlive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
