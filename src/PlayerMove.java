public class PlayerMove implements GameObjectAttributes<Player> {

    int acceleration = 1;
    float velocityX = 0;
    float velocityY = 2;
    float terminal_velocity = 2;
    float gravity = 0.15f;
    public PlayerMove() {

    }

    @Override
    public void run(Player player) {
        AxisX();
        AxisY(player);
        player.velocity.set(velocityX,velocityY);
        player.position.subtractBy(player.velocity);

    }

    public void AxisX(){
        if (KeybroadInput.instance.isLeft) {

                velocityX += 0.1;
        }
        if (KeybroadInput.instance.isRight) {
//            if(velocityX < 2)
                velocityX -= 0.1;
        }
    }

    public void AxisY(Player player){
        CloudSteady cloudSteady = GameObjectManager.instance.checkCollision(player);
        if(cloudSteady != null ){
            this.velocityY = 6;
            this.velocityX = 0;
        }
        if(this.velocityY > - terminal_velocity ){
            this.velocityY -= gravity;
        }
//        switch (this.acceleration){
//            case -1:
//
//                velocityY = - 1;
//
//                break;
//            case 1:
//                velocityY = 2;
//                break;
//        }

    }

}
