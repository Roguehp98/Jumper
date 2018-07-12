public class Player extends GameObject {

    Vector2D velocity;

    BoxCollider boxCollider;

    public Player(){
        this.renderer = new ImageRenderer("resource/circle.png",10,10);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);
        this.attributes.add(new PlayerMove());
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 5, this.position.y - 5);
    }
}
