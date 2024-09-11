package multithreading.multithread;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */
public class ThreadSafeQueue {
    int capacity;
    java.util.Queue<Integer> linkedList = new LinkedList<>();
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition isFull = reentrantLock.newCondition();
    Condition isEmpty = reentrantLock.newCondition();

    void put(int value) {
        reentrantLock.lock();
        try {
            while (capacity == linkedList.size()) {
                isFull.await();
            }
            linkedList.add(value);
            isEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }

    int get() {
        reentrantLock.lock();
        try {
            while (linkedList.isEmpty()) {
                isEmpty.await();
            }
            int r = linkedList.poll();
            isFull.signal();
            return r;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }


}
