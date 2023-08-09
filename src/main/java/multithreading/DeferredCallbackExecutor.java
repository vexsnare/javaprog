package multithreading;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeferredCallbackExecutor {
    PriorityQueue<Callback> pq = new PriorityQueue<>((x, y) -> (int) (x.executeAt - y.executeAt));

    private long findSleepForTime() {
        return pq.peek().executeAt - System.currentTimeMillis();
    }

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void start() throws InterruptedException {
        long sleepFor = 0;

        while (true) {

            lock.lock();

            while (pq.isEmpty()) {
                condition.await();
            }
            while (!pq.isEmpty()) {
                sleepFor = findSleepForTime();
                if(sleepFor <= 0) break;
                condition.await(sleepFor, TimeUnit.MILLISECONDS);
            }
            Callback callback = pq.poll();
            System.out.println("Calling callback " + callback.message);
            lock.unlock();
        }
    }

    public void registerCallback(Callback callback) {
        lock.lock();
        pq.add(callback);
        condition.signal();
        lock.unlock();
    }

    static class Callback {
        long executeAt;
        String message;

        public Callback(long executeAt, String message) {
            this.executeAt = executeAt;
            this.message = message;
        }
    }
}


class DeferredCallbackExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

        Thread service = new Thread(() -> {
            try {
                deferredCallbackExecutor.start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        service.start();

        DeferredCallbackExecutor.Callback callback = new DeferredCallbackExecutor.Callback(System.currentTimeMillis() + 2000, "Message 1");
        deferredCallbackExecutor.registerCallback(callback);

        DeferredCallbackExecutor.Callback callback2 = new DeferredCallbackExecutor.Callback(System.currentTimeMillis() + 1000, "Message 2");
        deferredCallbackExecutor.registerCallback(callback2);


    }
}