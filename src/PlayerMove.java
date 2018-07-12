public class PlayerMove implements GameObjectAttributes<Player> {

    int acceleration = 1;
    int maxHeight = 100;
    int velocityX = 0;
    int velocityY = 2;
    public PlayerMove() {

    }

    @Override
    public void run(Player player) {
        AxisX();
        AxisY(player);
        player.velocity.set(velocityX,velocityY);
        player.position.addUp(player.velocity);

    }

    public void AxisX(){
        if (KeybroadInput.instance.isLeft) {
            velocityX = -1;
        }
        if (KeybroadInput.instance.isRight) {
            velocityX = 1;
        }
    }

    public void AxisY(Player player){
        CloudSteady cloudSteady = GameObjectManager.instance.checkCollision(player);
        if(cloudSteady != null ){
            this.acceleration = -1;
            velocityX = 0;
        }
        if(this.maxHeight == 0){
            this.acceleration = 1;
            this.maxHeight = 100;
        }
        switch (this.acceleration){
            case -1:
                velocityY = -2;
                maxHeight += velocityY;
                break;
            case 1:
                velocityY = 2;
                break;
        }
    }

}
