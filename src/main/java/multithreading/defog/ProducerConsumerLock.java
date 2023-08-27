package multithreading.defog;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLock {

    private Lock lock = new ReentrantLock();
    private Condition added = lock.newCondition();
    private Condition removed = lock.newCondition();

    int count = 0;
    int max_count;
    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (count == max_count) {
                removed.await();
            }
            // add data
            added.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                added.await();
            }
            // remove data
            removed.signal();
        } finally {
            lock.unlock();
        }
    }
}
