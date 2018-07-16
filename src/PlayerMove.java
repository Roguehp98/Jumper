public class PlayerMove implements GameObjectAttributes<Player> {

    int acceleration = 1;
    float velocityX = 0;
    float velocityY = 2;
    float terminal_velocity = 2;
    float gravity = 0.2f;
    public PlayerMove() {

    }

    @Override
    public void run(Player player) {
        AxisX();
        AxisY(player);
//       `
        player.velocity.set(velocityX,velocityY);
        player.position.subtractBy(player.velocity);

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
        if(cloudSteady != null ){
            this.velocityY = 7;/* */
            this.velocityX = 0;
        }
//        if(this.velocityY > - terminal_velocity ){
            this.velocityY -= gravity;
//        }
    }

}
