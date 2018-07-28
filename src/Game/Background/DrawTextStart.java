package Game.Background;

import Base.GameObject;
import Renderer.TextRenderer;

import java.awt.*;

public class DrawTextStart extends GameObject {
    public DrawTextStart() {
        this.renderer = new TextRenderer(
                "Jumper",
                Color.RED,
                ".VnCourier New",
                30
        );
    }

}
