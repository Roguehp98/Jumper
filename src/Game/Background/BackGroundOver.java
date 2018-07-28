package Game.Background;

import Base.GameObject;
import Renderer.BackgroundRenderer;

import java.awt.*;

public class BackGroundOver extends GameObject {

    public BackGroundOver(){
        this.renderer = new BackgroundRenderer(
                0,
                0,
                450,
                800,
                Color.BLUE
        );
    }
}
