public class ModNCounter {

    private int myCount;

    public ModNCounter() {
        myCount = 0;
    }

    public ModNCounter(int n)
    {
        this.myCount=n;
    }

    public void increment() {
        myCount++;
    }

    public void reset() {
        myCount = 0;
    }

    public int value() {
        return myCount;
    }

}
