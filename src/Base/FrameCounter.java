package Base;

public class FrameCounter {
    private int count;
    private int timeInterval;

    public FrameCounter(int timeInterval) {
        this.count = 0;
        this.timeInterval = timeInterval;
    }

    public boolean run(){
        if(this.count == this.timeInterval){
            return true;
        }else{
            this.count++;
            return false;
        }
    }
    public void reset(){
        this.count = 0;
    }
}
