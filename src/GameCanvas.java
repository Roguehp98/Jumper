import Base.GameObjectManager;
import Base.Vector2D;
import Game.Background.Background;
import Game.Cloud.CloudSteady;
import Game.Cloud.CreateCouldJump;
import Game.Cloud.CreateDriftingCloud;
import Game.Enemy.EnemySin;
import Game.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    Graphics graphics;
    BufferedImage backBuffered;
    public GameCanvas(){
        this.setSize(600,800);
        setUpBackBuffered();
        CreateCouldJump createCouldJump = GameObjectManager.instance.recycle(CreateCouldJump.class);
        createCouldJump.configAction();
        CreateDriftingCloud createDriftingCloud = GameObjectManager.instance.recycle(CreateDriftingCloud.class);
        createDriftingCloud.configAction();
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new CloudSteady(300,600));
        GameObjectManager.instance.add(new EnemySin());

        this.setupPlayer();
        this.setVisible(true);
    }

    public void setupPlayer(){
        Player player = new Player();
        player.position.set(new Vector2D(300,450));
        GameObjectManager.instance.add(player);
    }



    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);
    }

    public void renderAll(){
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }

    public void runAll(){
        GameObjectManager.instance.runAll();
    }
    public void setUpBackBuffered(){
        backBuffered = new BufferedImage(450,800,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }


}
