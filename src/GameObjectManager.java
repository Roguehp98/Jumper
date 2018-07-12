import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {
    public static GameObjectManager instance = new GameObjectManager();
    private List<GameObject> list = new ArrayList<>();
    private List<GameObject> tempList = new ArrayList<>();

    public GameObjectManager(){

    }

    public void add(GameObject gameObject){
        this.tempList.add(gameObject);
    }

    public void runAll(){
        this.list.forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics){
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }

    public CloudSteady findCloud(){
        return (CloudSteady) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof CloudSteady)
                .findFirst()
                .orElse(null);
    }
//
//    public Cloud checkCollision(Player player){
//        return (Cloud) this.list
//                                .stream()
//                                .filter(gameObject -> gameObject instanceof Cloud)
//                                .filter(gameObject -> {
//                                    BoxCollider other = ((Cloud) gameObject).boxCollider;
//                                    return player.boxCollider.checkCollision(other);
//                                })
//                                .findFirst()
//                                .orElse(null);
//    }

    public CloudSteady checkCollision(Player player){
        return (CloudSteady) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof CloudSteady)
                .filter(gameObject -> {
                    BoxCollider other = ((CloudSteady) gameObject).boxCollider;
                    return player.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

}
