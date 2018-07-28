package Game.Enemy.EnemyFly;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyShoot;
import Game.Player.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;
import Scene.GameStartScene;
import Scene.SceneManager;

public class EnemySin extends GameObject implements PhysicBody {
    Vector2D velocity;
    int count = -5;
    int change = 0;
    double angle;
    BoxCollider boxCollider;
    RunHitObj runHitObj;
    public static float distanceBetweenPlayerAndEnemySin;
    int facing = 1;

    public EnemySin(int x, int y) {
        this.velocity = new Vector2D(-1, 0);
        this.renderer = new ImageRenderer("resource/image/Character/EnemyFly.png", 30, 30);
        this.position.set(x, y);
        this.boxCollider = new BoxCollider(30, 30);
        this.attributes.add(new EnemySinShoot());
        this.runHitObj = new RunHitObj(Player.class);
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObjectManager.instance.findObject(Player.class);
        if (player != null)
            this.distanceBetweenPlayerAndEnemySin = this.position.copy().subtractBy(player.position).length();
        if (this.position.x < 0 || this.position.x > 600) {
            if(this.position.x > 600)
                this.facing = -1;
            if(this.position.x < 0)
                this.facing = 1;
            this.velocity.x = -this.velocity.x;

        }
        flippingImage();
        angle = 15 * count;
        double radians = Math.toRadians(angle);
        this.velocity.y = 2 * (float) (Math.sin(radians));
        this.boxCollider.position.set(this.position.x -15,this.position.y -15);
        this.position.subtractBy(this.velocity);
        this.runHitObj.run(this);
        reset();
}

    public void reset() {
        if (count == 5)
            change = 0;
        if (count == -5)
            change = 1;
        switch (change) {
            case 0:
                count -= 1;
                break;
            case 1:
                count += 1;
                break;
        }
    }

    public void flippingImage(){
        switch (facing){
            case 1:
                this.renderer = new ImageRenderer("resource/image/Character/EnemyFly.png", 30, 30);
                break;
            case -1:
                this.renderer = new ImageRenderer("resource/image/Character/EnemyFlyFlipping.png", 30, 30);
                break;
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
