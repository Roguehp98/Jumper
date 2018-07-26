package Game.Enemy.EnemyFly;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Player.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;

public class EnemySin extends GameObject implements PhysicBody {
    Vector2D velocity;
    int count = -5;
    int change = 0;
    double angle;
    BoxCollider boxCollider;
    RunHitObj runHitObj;
    float distanceBetweenPlayerAndEnemySin;

    public EnemySin() {
        this.velocity = new Vector2D(-1, 0);
        this.renderer = new ImageRenderer("resource/image/star.png", 30, 30);
        this.position.set(0, 200);
        this.boxCollider = new BoxCollider(30, 30);
        this.attributes.add(new EnemyThrow());
        this.runHitObj = new RunHitObj(Player.class);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.x < 0 || this.position.x > 600) {
            this.velocity.x = -this.velocity.x;
        }
        angle = 15 * count;
        double radians = Math.toRadians(angle);
        this.velocity.y = 2 * (float) (Math.sin(radians));
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
        this.position.subtractBy(this.velocity);

//        Player player = GameObjectManager.instance.findObject(Player.class);
//        if (player != null)
//            this.distanceBetweenPlayerAndEnemySin = this.position.copy().subtractBy(player.position).length();
//        if ((int) this.distanceBetweenPlayerAndEnemySin < 26){
//            this.attributes.add(new EnemyRage());
//            this.attributes.remove(new EnemyThrow());
//        }else this.attributes.add(new EnemyThrow());

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

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
