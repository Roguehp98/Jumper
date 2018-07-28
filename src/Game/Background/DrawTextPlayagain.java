package Game.Background;

import Base.GameObject;
import Renderer.TextRenderer;

import java.awt.*;

public class DrawTextPlayagain extends GameObject {
    public DrawTextPlayagain() {
        this.renderer = new TextRenderer(
                "Click Enter to Playagain",
                Color.RED,
                ".VnCourier New",
                20
        );
    }
}
