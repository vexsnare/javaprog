package multithreading.defog;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    private Lock lock = new ReentrantLock();
    private Condition conditionMet = lock.newCondition();

    public void method1() throws InterruptedException {
        lock.lock();
        try {
            conditionMet.await();
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();
        try {
            conditionMet.signal();
        } finally {
            lock.unlock();
        }
    }

}
