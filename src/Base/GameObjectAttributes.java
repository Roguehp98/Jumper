package Base;

import Base.GameObject;

public interface GameObjectAttributes<T extends GameObject> {
    void run(T gameObject);
}
