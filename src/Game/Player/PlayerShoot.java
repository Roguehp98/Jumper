package Game.Player;

import Base.*;
import Input.KeybroadInput;
import Physic.BoxCollider;
import Physic.PhysicBody;

public class PlayerShoot implements GameObjectAttributes<Player> {
    private FrameCounter frameCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(20);
    }

    @Override
    public void run(Player player) {
        if (this.frameCounter.run()) {
            if (player.isAlive)
                if (KeybroadInput.instance.isSpace && player.velocity.x != 0) {
                    PlayerBullet playerBullet = GameObjectManager.instance.recycle(PlayerBullet.class);
                    playerBullet.position.set(player.position);
                    playerBullet.velocity.set(new Vector2D(-player.velocity.x, 0).multiply(2f));
                    outScreen(playerBullet);
                    this.frameCounter.reset();
                }
        }
    }
    public void outScreen(PlayerBullet playerBullet){
        if(playerBullet.position.x < 0|| playerBullet.position.x > 480)
            playerBullet.isAlive = false;
    }
}
