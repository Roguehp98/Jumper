package Action;

import Base.GameObject;

public abstract class ActionAdapter implements Action {
    // abstract class kha giong voi interface chi can khai bao ham

    @Override
    public boolean run(GameObject owner) {
        return false;
    }

    @Override
    public void reset() {

    }
}
