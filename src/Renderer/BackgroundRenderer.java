package Renderer;

import Base.Vector2D;

import java.awt.*;

public class BackgroundRenderer implements Renderer {

    int x,y,width,height;
    Color color;

    public BackgroundRenderer(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(color);
        graphics.fillRect(this.x,this.y,this.width,this.height);
    }
}
