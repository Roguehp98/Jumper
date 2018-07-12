import java.awt.*;
import java.util.Random;

public class Cloud extends GameObject {

    public BoxCollider boxCollider;
    public Vector2D velocity;

    Random random = new Random();
    public Cloud(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resource/cloud.png",30,20);
        this.position.set(random.nextInt(400),800);
        this.boxCollider = new BoxCollider(30,20);

    }

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }
}
