package multithreading;

import java.util.PriorityQueue;

public class DeferredCallbackExecutor {
    PriorityQueue<Callback> pq = new PriorityQueue<>((x, y) -> (int) (x.executeAt - y.executeAt));

    private long findSleepForTime() {
        return pq.peek().executeAt - System.currentTimeMillis();
    }
    public void start() {

    }

    public void registerCallback(Callback callback) {

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
