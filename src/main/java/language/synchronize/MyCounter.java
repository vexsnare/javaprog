package language.synchronize;

/**
 * @author vinay.saini
 * @created 20/07/2020 - 9:37 PM
 */

// One thread per instance
public class MyCounter {
    private int counter = 0;
    public void add(int value) {
        synchronized (this) {
            this.counter += value;
        }
    }
    public synchronized void substract(int value) {
        this.counter -= value;
    }
}
