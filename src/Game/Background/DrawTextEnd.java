package Game.Background;

import Base.GameObject;
import Renderer.TextRenderer;

import java.awt.*;

public class DrawTextEnd extends GameObject {
    public DrawTextEnd() {
        this.renderer = new TextRenderer(
                "Game Over!!",
                Color.RED,
                ".VnCourier New",
                30
        );
    }

}
