package Game.Player;

import Base.*;
import Input.KeybroadInput;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Utils.Utils;

import javax.sound.sampled.Clip;

public class PlayerShoot implements GameObjectAttributes<Player> {
    private FrameCounter frameCounter;
    private Clip clip;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(20);
        this.clip = Utils.loadAudio("resource/audio/smb_fireball.wav");
    }

    @Override
    public void run(Player player) {
        if (this.frameCounter.run()) {
            if (player.isAlive)
                if (KeybroadInput.instance.isSpace && player.velocity.x != 0) {
                    PlayerBullet playerBullet = GameObjectManager.instance.recycle(PlayerBullet.class);
                    playerBullet.position.set(player.position);
                    playerBullet.velocity.set(new Vector2D(-player.velocity.x, 0).multiply(2f));
                    this.clip.loop(1);
                    this.clip.start();
                    this.frameCounter.reset();
                }
        }
    }
}
