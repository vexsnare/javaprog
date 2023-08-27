package multithreading.defog;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    private static ReentrantLock lock = new ReentrantLock(true);
    private static void accessResources() {
        boolean lockAcquired = lock.tryLock();
        // boolean lockAcquired = lock.tryLock(true);
        if(lockAcquired) {
            try {
                // do something
            } finally {
                lock.unlock();
            }
        }
    }
}
