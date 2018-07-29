package Game.Player;

import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Game.Cloud.CloudJump;
import Game.Cloud.CloudSteadyStart;
import Game.Cloud.CloudSteadyinGamePlay;
import Game.Cloud.DriftingCloud;
import Highscore.Score;
import Input.KeybroadInput;
import Utils.Utils;

import javax.sound.sampled.Clip;

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
        CloudSteadyinGamePlay cloudSteadyinGamePlay = GameObjectManager.instance.checkCollision(player.boxCollider,CloudSteadyinGamePlay.class);
        CloudJump cloudJump = GameObjectManager.instance.checkCollision(player.boxCollider,CloudJump.class);
        DriftingCloud driftingCloud = GameObjectManager.instance.checkCollision(player.boxCollider,DriftingCloud.class);
        CloudSteadyStart cloudSteadyStart = GameObjectManager.instance.checkCollision(player.boxCollider,CloudSteadyStart.class);
        if (this.velocityY <= 0) {
            if (cloudJump != null || cloudSteadyinGamePlay != null || driftingCloud != null || cloudSteadyStart != null) {
                this.velocityY = 7;/* */
                this.velocityX = 0;
                this.clip = Utils.loadAudio("resource/audio/jump.wav");
                this.clip.loop(0);
                this.clip.start();
                if(cloudJump != null) {
                    if(cloudJump.checkScore == true) {
                        Score.score += 20;
                        cloudJump.checkScore = false;
                    }
                }
            }
        }else{
            if(cloudJump != null || cloudSteadyinGamePlay != null || driftingCloud != null){
                this.velocityY = 0;
                this.clip = Utils.loadAudio("resource/audio/smb_bump.wav");
                this.clip.loop(0);
                this.clip.start();
            }

        }
        this.velocityY -= gravity;
    }


}


