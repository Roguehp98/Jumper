public class CreateCould extends GameObject {
    FrameCounter frameCounter;

    public CreateCould(){
        this.frameCounter = new FrameCounter(40);

    }
    public void run(){
        if(this.frameCounter.run()){
            Cloud cloud = new Cloud();
            cloud.velocity.set(new Vector2D(0,-2));
            GameObjectManager.instance.add(cloud);
            this.frameCounter.reset();
        }
    }

//    public void render(Graphics graphics){
//        clouds.forEach(cloud -> cloud.render(graphics));
//    }
}
