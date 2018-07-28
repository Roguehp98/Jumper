package Game.Player;

import Base.GameObject;
import Base.Vector2D;
import Game.Enemy.EnemyJump.EnemyPlatform;
import Game.Enemy.EnemyJump.EnemyPlatformBullet;
import Game.Enemy.EnemyFly.EnemySin;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Physic.RunHitObj;
import Renderer.ImageRenderer;
import Scene.GameOverScene;
import Scene.GamePlayScene;
import Scene.GameStartScene;
import Scene.SceneManager;


public class Player extends GameObject implements PhysicBody {

    public Vector2D velocity;

    public BoxCollider boxCollider;
    public static boolean changeVelocity = false;

    private RunHitObj runHitObj;

    public Player() {
        this.renderer = new ImageRenderer("resource/image/Character/Player.png", 30, 30);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(30, 30);
        this.attributes.add(new PlayerMove());
        this.attributes.add(new PlayerShoot());
        this.runHitObj = new RunHitObj(
                EnemyPlatformBullet.class,
                EnemySin.class,
                EnemyPlatform.class
        );
    }

    @Override
    public void run() {
        super.run();
        if(SceneManager.instance.getCurrentScene() instanceof GameStartScene){
            this.renderer = new ImageRenderer("resource/image/Character/Player.png", 60, 60);
            this.boxCollider = new BoxCollider(60,60);
            this.boxCollider.position.set(this.position.x - 30, this.position.y - 30);
        }else {
            this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
        }
        runHitObj.run(this);
        this.outScreen();
    }

    public void outScreen(){
        if(this.position.x < 0 || this.position.y < 0 || this.position.x > 450 || this.position.y > 800) {
            this.isAlive = false;
            SceneManager.instance.changeScene(new GameOverScene());
        }
    }


    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof EnemyPlatformBullet
                || gameObject instanceof EnemySin
                || gameObject instanceof EnemyPlatform) {
            this.isAlive = false;
            SceneManager.instance.changeScene(new GameOverScene());
        }
    }

}
