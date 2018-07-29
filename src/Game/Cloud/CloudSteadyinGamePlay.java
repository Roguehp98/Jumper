package Game.Cloud;

import Action.*;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Player.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

import java.util.Random;

public class CloudSteadyinGamePlay extends GameObject implements PhysicBody {

    public Vector2D velocity;

    public BoxCollider boxCollider;
    int x;
    int y;


    public static Vector2D loadLocationCloudSteady;
    Random random = new Random();

    public CloudSteadyinGamePlay() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/image/cloud.png", 50, 20);
        this.loadLocationCloudSteady = new Vector2D();
//        this.position.set(x, y);
        this.boxCollider = new BoxCollider(50, 20);
    }

    public void run() {
        this.position.set(200, 400);
        loadLocationCloudSteady.set(this.position.copy());
        Player player = GameObjectManager.instance.findObject(Player.class);
//        this.boxCollider.position.set(this.position.x - 25,this.position.y -10);
        if (player != null)
            if (player.velocity.y > 0) {
                this.boxCollider = new BoxCollider(50, 1);
                this.boxCollider.position.set(this.position.x - 25, this.position.y + 10);
            } else {
                this.boxCollider = new BoxCollider(50, 1);
                this.boxCollider.position.set(this.position.x - 25, this.position.y - 10);
            }
        if (player != null)
            if (player.position.x != 200 && player.velocity.y > 5 && player.velocity.y < 6)
                this.isAlive = false;
        addAction(
                new LimitAction(
                        1,
                        new SequenceAction(
                                new WaitAction(1000),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        CloudSteadyinGamePlay cloudSteadyinGamePlay = GameObjectManager.instance.findObject(CloudSteadyinGamePlay.class);
                                        cloudSteadyinGamePlay.isAlive = false;
                                        return true;
                                    }
                                }
                        )
                )
        );

    }


    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
