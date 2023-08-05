package adhoc.dream11;

import multithreading.BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class TopicImpl implements Topic {
    Queue<String> q;
    int size = 0;
    public TopicImpl(int capacity) {
        q = new LinkedList<>();
    }
    @Override
    public synchronized String getMessage() throws InterruptedException {
        while (q.isEmpty()) {
            wait();
        }
        String message = q.poll();
        System.out.println("polled message " + message);
        q.remove();
        notifyAll();
        return message;
    }

    @Override
    public synchronized void putMessage(String message) throws InterruptedException {
        q.add(message);
        System.out.println("Added message " + message);
        size += 1;
        notifyAll();
    }
}
