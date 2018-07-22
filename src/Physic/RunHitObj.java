package Physic;

import Base.GameObject;
import Base.GameObjectManager;

import java.util.Arrays;
import java.util.List;

public class RunHitObj<B extends GameObject & PhysicBody> {
    private List<Class<B>> list;
    public RunHitObj(Class<B>... classes){
        this.list = Arrays.asList(classes);
    }

    public <A extends GameObject & PhysicBody> void run(A object){
        this.list
                .stream()
                .map(cls -> GameObjectManager.instance.checkCollision(object.getBoxCollier(),cls))
                .filter(gameObject -> gameObject != null)
                .forEach(gameObject -> {
                    gameObject.getHit(object);
                    object.getHit(gameObject);
                });
    }
}
