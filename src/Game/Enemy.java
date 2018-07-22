package Game;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;

public class Enemy extends GameObject {
    Vector2D velocity;
    int count = -5;
    int change = 0;
    double angle ;

    public Enemy(){
        this.velocity = new Vector2D(-1,0);
        this.renderer = new ImageRenderer("resource/star.png",30,30);
        this.position.set(0,200);
    }

    @Override
    public void run() {
        super.run();
        if(this.position.x < 0 || this.position.x > 600){
            this.velocity.x = -this.velocity.x ;
        }
        angle = 15 * count;
        double radians = Math.toRadians(angle);
        this.velocity.y = (float)(Math.sin(radians));
        this.position.subtractBy(this.velocity);
        reset();

    }

    public void reset(){
        if(count == 5)
            change = 0;
        if(count == -5)
            change = 1;
       switch (change){
           case 0:
               count -= 1;
               break;
           case 1:
               count += 1;
               break;
       }
    }
}
