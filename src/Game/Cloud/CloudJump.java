package Game.Cloud;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyPlatformBullet;
import Game.Player.Player;
import Highscore.Score;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class CloudJump extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    public Vector2D velocity;
    int zoneCloud;
    int location;
    private RunHitObj runHitObj;
    Random random = new Random();

    public boolean checkScore;

    public CloudJump() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/image/cloud.png", 50, 20);
        this.boxCollider = new BoxCollider(50, 1);
        this.runHitObj = new RunHitObj(EnemyPlatformBullet.class);
        this.checkScore = true;
    }

    public void run() {
        super.run();
        if (Score.score < 1000)
            this.velocity.set(new Vector2D(0, 1));
        if (Score.score >= 1000)
            this.velocity.set(new Vector2D(0, 2));
        Player player = GameObjectManager.instance.findObject(Player.class);
        if (player != null)
            if (player.velocity.y > 0) {
//            this.boxCollider = new BoxCollider(50,1);
                this.boxCollider.position.set(this.position.x - 25, this.position.y + 10);
            } else {
//            this.boxCollider = new BoxCollider(50,1);
                this.boxCollider.position.set(this.position.x - 25, this.position.y - 10);
            }
        this.runHitObj.run(this);
        this.position.addUp(this.velocity);
        this.outSreen();

    }

    public void outSreen() {
        if (this.position.y > 800) {
            this.position.y = 0;
            this.resetPositionX();
            checkScore = true;
        }
    }

    public void resetPositionX() {
        this.zoneCloud = random.nextInt(2);
        randomLocaion();
        this.position.x = CreateCouldJump.loadLocationCloudBefore.x - location * random.nextInt(108) - location * 10;
        if (this.position.x < 90 || this.position.x > 350) {
            this.position.x = CreateCouldJump.loadLocationCloudBefore.x - (-1) * location * random.nextInt(108) + location * 10;
        }
        CreateCouldJump.loadLocationCloudBefore.set(this.position.copy());
    }

    public void randomLocaion() {
        switch (this.zoneCloud) {
            case 0:
                location = -1;
                break;
            case 1:
                location = 1;
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
