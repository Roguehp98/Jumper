package Game.Player;

import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Game.Cloud.CloudJump;
import Game.Cloud.CloudSteady;
import Game.Cloud.DriftingCloud;
import Input.KeybroadInput;
import Physic.RunHitObj;
import Utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.event.KeyListener;

public class PlayerMove implements GameObjectAttributes<Player> {


    float velocityX = 0;
    float velocityY = 1;
    float gravity = 0.3f;
    private Clip clip;


    public PlayerMove() {
    }

    @Override
    public void run(Player player) {
        AxisX();
        AxisY(player);
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

    public void AxisY(Player player) {
        CloudSteady cloudSteady = GameObjectManager.instance.checkCollision(player.boxCollider,CloudSteady.class);
        CloudJump cloudJump = GameObjectManager.instance.checkCollision(player.boxCollider,CloudJump.class);
        DriftingCloud driftingCloud = GameObjectManager.instance.checkCollision(player.boxCollider,DriftingCloud.class);

        if (this.velocityY <= 0) {
            if (cloudJump != null || cloudSteady != null || driftingCloud != null) {
                this.velocityY = 7;/* */
                this.velocityX = 0;
                this.clip = Utils.loadAudio("resource/audio/jump.wav");
                this.clip.loop(0);
                this.clip.start();
            }
        }else{

            if(cloudJump != null || cloudSteady != null || driftingCloud != null){
                this.velocityY = 0;
                this.clip = Utils.loadAudio("resource/audio/smb_bump.wav");
                this.clip.loop(0);
                this.clip.start();
//                Player.changeVelocity = false;
            }

        }
        this.velocityY -= gravity;



    }


}


