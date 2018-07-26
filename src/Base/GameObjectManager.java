package Base;

import Game.Cloud.CloudJump;
import Game.Cloud.CloudSteady;
import Game.Player.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {
    public static GameObjectManager instance = new GameObjectManager();
    private List<GameObject> list = new ArrayList<>();
    private List<GameObject> tempList = new ArrayList<>();
    int countCloud = 0;

    public GameObjectManager(){

    }

    public void add(GameObject gameObject){
        this.tempList.add(gameObject);
    }

    public void runAll(){
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
//        System.out.println(this.list.size());
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics){
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }


    public <T extends GameObject & PhysicBody> T findObject(Class<T> cls){
        return (T) this.list
                .stream()
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> gameObject.isAlive)
                .findFirst()
                .orElse(null);
    }
    public int countCloud(){
        this.list
                .stream()
                .filter(gameObject -> gameObject instanceof CloudJump)
                .forEach(gameObject -> this.countCloud++);
        return this.countCloud;
    }



    public <T extends GameObject & PhysicBody> T checkCollision(BoxCollider boxCollider, Class<T> cls){
        return (T) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive )
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> {
                    BoxCollider other = ((T) gameObject).getBoxCollier();
                    return boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T recycle(Class<T> cls) {
        T gameObject = (T) this.list
                .stream()
                .filter(object -> cls.isInstance(object))
                .filter(object -> !object.isAlive)
                .findFirst()
                .orElse(null);
        if (gameObject != null) {
            gameObject.isAlive = true;
            return gameObject;
        } else {
            try {
                gameObject = cls.newInstance();
                this.add(gameObject);
                return gameObject;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }





}
