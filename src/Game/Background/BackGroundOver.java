package Game.Background;

import Base.GameObject;
import Base.Vector2D;
import Renderer.BackgroundRenderer;
import Renderer.ImageRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGroundOver extends GameObject {

    public BufferedImage image = this.loadImage("resource/image/Background/background.png");

    public BackGroundOver() {
        this.renderer = new ImageRenderer("resource/image/Background/background.png", 450, 800);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, 0, 0, 450, 800, null);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
