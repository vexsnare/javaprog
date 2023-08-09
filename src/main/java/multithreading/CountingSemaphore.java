package multithreading;

public class CountingSemaphore {
    int count;
    int maxCount;
    CountingSemaphore(int maxCount) {
        this.maxCount = maxCount;
    }
    public synchronized void acquireLock() throws InterruptedException {
        while (count == maxCount) {
            wait();
        }
        count++;
        notify();
    }
    public synchronized void releaseLock() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        count--;
        notify();
    }
}
