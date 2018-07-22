package Action;

import Base.GameObject;

public class LimitAction implements Action {
    private int count;
    private Action action;

    public LimitAction(int count, Action action) {
        this.count = count;
        this.action = action;
    }

    @Override
    public boolean run(GameObject owner) {
        if(this.action.run(owner)){
            this.action.reset();
            if(this.count == 1){
                return true;
            }else this.count --;
        }
        return false;
    }

    @Override
    public void reset() {

    }
}
