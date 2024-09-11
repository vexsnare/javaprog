package multithreading.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */
public class RWLock {

    volatile boolean isWrite = false;
    AtomicInteger read = new AtomicInteger(0);
    public boolean acquireReadLock() throws InterruptedException {
        while (isWrite) wait();
        read.getAndAdd(1);
        return true;
    }

    public void releaseReadLock() {
        read.decrementAndGet();
        notifyAll();
    }

    public boolean acquireWriteLock() throws InterruptedException {
        while (isWrite || read.get() > 0) {
            wait();
        }
        isWrite = true;
        return true;

    }

    public void releaseWriteLock() {
        isWrite = false;
        notifyAll();
    }

}
