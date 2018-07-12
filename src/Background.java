import java.awt.*;

public class Background extends GameObject {

    public Background(){
        this.renderer = new BackgroundRenderer(
                0,
                0,
                400,
                800,
                Color.CYAN
        );
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }
}
