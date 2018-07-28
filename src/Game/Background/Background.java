package Game.Background;

import Base.GameObject;
import Renderer.BackgroundRenderer;


import java.awt.*;

public class Background extends GameObject {

    public Background(){
        this.renderer = new BackgroundRenderer(
                0,
                0,
                450,
                800,
                Color.BLUE
        );
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }
}
