package Game.Background;

import Base.GameObject;
import Renderer.ImageRenderer;
import Renderer.TextRenderer;

import java.awt.*;

public class ButtonStart extends GameObject {
    public ButtonStart(){
        this.renderer = new ImageRenderer("resource/image/Button/Button_Start.png",200,200);
    }
}
