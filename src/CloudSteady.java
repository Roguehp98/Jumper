import java.util.Random;

public class CloudSteady extends GameObject {

    public Vector2D velocity;

    BoxCollider boxCollider;

    Random random = new Random();
    public CloudSteady(int x, int y){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/cloud.png",30,20);
        this.position.set(new Vector2D(x,y));
        this.boxCollider = new BoxCollider(30,20);
    }

    public void run(){
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
    }


}
