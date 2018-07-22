package Physic;

import Base.GameObject;

public interface PhysicBody {
    BoxCollider getBoxCollier();

    void getHit(GameObject gameObject);
}
