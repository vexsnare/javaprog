package multithreading.defog;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    private Lock lock = new ReentrantLock();
    private Condition conditionMet = lock.newCondition();
    private Condition conditionMet2 = lock.newCondition();

    public void method1() throws InterruptedException {
        lock.lock();
        try {
            conditionMet.await();


            conditionMet2.await();
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();
        try {
            conditionMet2.signal();
            conditionMet.signal();


        } finally {
            lock.unlock();
        }
    }

}
