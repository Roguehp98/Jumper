package Game.Player;

import Base.GameObjectAttributes;
import Base.GameObjectManager;
import Game.Cloud.CloudSteady;
import Input.KeybroadInput;

public class PlayerMove implements GameObjectAttributes<Player> {

//    int acceleration = 1;
    float velocityX = 0;
    float velocityY = 1;
//    float terminal_velocity = 2;
    float gravity = 0.3f;

    public PlayerMove() {

    }

    @Override
    public void run(Player player) {
        AxisX();
        AxisY(player);
//       `

        player.velocity.set(velocityX,velocityY);
        player.position.subtractBy(player.velocity);

//        if(this.velocityY == 7){
//             b = player.position.y;
//            System.out.println("b = " + b);
//        }
//        System.out.println("a - b = " + (a-b));
//        System.out.println("------------");

    }

    public void AxisX(){

        if (KeybroadInput.instance.isLeft) {

                velocityX = 2;/* */
        }
        if (KeybroadInput.instance.isRight) {
//            if(velocityX < 2)
                velocityX = -2;/* */
        }

    }

    public void AxisY(Player player){
        CloudSteady cloudSteady = GameObjectManager.instance.checkCollision(player);
//        Game.CloudJump.CloudJump cloud = Base.GameObjectManager.instance.checkCollision1(player);
        if(this.velocityY <= 0){
            if(cloudSteady != null ){
                this.velocityY = 7;/* */
                this.velocityX = 0;

            }
        }else{
            if(cloudSteady != null){
                this.velocityY = 0;
            }
        }
//        if(this.velocityY > - terminal_velocity ){

            this.velocityY -= gravity;
//        }
    }

}
