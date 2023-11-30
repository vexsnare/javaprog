package algorithms.app;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vinay.saini
 * @created 30/08/2020 - 9:35 AM
 */



public class RateLimiter {
    static class Request {
        Long timestamp;
    }
    Queue<Long> q = new LinkedList<>();
    long time;
    int maxRequest;
    RateLimiter(long time, int maxRequest) {
        this.time = time;
        this.maxRequest = maxRequest;
    }

    public boolean isAllowed(Request request) {
        if(q.size() < maxRequest) {
            q.add(request.timestamp);
            return true;
        } else {
            removeExpired();
            if (q.size() < maxRequest) {
                q.add(request.timestamp);
                return true;
            }
            return false;
        }
    }

    private void removeExpired() {
        Long currentTime = Calendar.getInstance().getTimeInMillis();

        while (!q.isEmpty()) {
            Long requestTime  = q.peek();
            if(currentTime - requestTime > time) {
                q.poll();
            }
        }
    }

}
