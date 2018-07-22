package Game.Player;

import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Game.Cloud.CloudJump;
import Game.Cloud.CloudSteady;
import Game.Cloud.DriftingCloud;
import Input.KeybroadInput;
import Physic.RunHitObj;

import java.awt.event.KeyListener;

public class PlayerMove implements GameObjectAttributes<Player> {


    float velocityX = 0;
    float velocityY = 1;
    float gravity = 0.3f;


    public PlayerMove() {

    }

    @Override
    public void run(Player player) {
        AxisX();
        AxisY();
        player.velocity.set(velocityX, velocityY);
        player.position.subtractBy(player.velocity);
    }

    public void AxisX() {
        if (KeybroadInput.instance.isLeft) {
            velocityX = 2;/* */
        }
        if (KeybroadInput.instance.isRight) {
            velocityX = -2;/* */
        }
    }

    public void AxisY() {
//        CloudSteady cloudSteady = GameObjectManager.instance.checkCollision(player.boxCollider,CloudSteady.class);

        if (this.velocityY < 0) {
            if (Player.changeVelocity) {
                this.velocityY = 7;/* */
                this.velocityX = 0;
//                System.out.println("up");
                Player.changeVelocity = false;
            }
        }
        if(this.velocityY > 0){
            if(Player.changeVelocity){
                this.velocityY = 0;
                Player.changeVelocity = false;
            }

        }
        this.velocityY -= gravity;



    }


}


