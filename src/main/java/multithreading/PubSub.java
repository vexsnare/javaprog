package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */
public class PubSub {
    private int MAX;
    ReentrantLock lock = new ReentrantLock();
    Condition isFull = lock.newCondition();
    Condition isEmpty = lock.newCondition();
    private Queue<Integer> q;
    PubSub(int maxSize) {
        this.MAX = maxSize;
        this.q = new LinkedList<>();
    }

    public void produce(int i) throws InterruptedException {
       lock.lock();
       try {
           while (q.size() >= MAX) {
               System.out.println(Thread.currentThread().getName() + " Full " + q.size());
               isFull.await();
           }
           System.out.println(Thread.currentThread().getName() + " Producing " + i);
           q.add(i);
           isEmpty.signal();
       } finally {
           lock.unlock();
       }

    }

    public int consume() throws InterruptedException {
        lock.lock();
        int r;
        try {
            while (q.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " Empty ");
                isEmpty.await();
            }
            r = q.poll();
            System.out.println("Consumer " + Thread.currentThread().getName() + " " + r);
            isFull.signal();
        } finally {

            lock.unlock();
        }
        return r;
    }

    public static void main(String[] args) {
        PubSub pubSub = new PubSub(8);
       // ExecutorService executorService = Executors.newFixedThreadPool(5);
        new Thread(new Producer(pubSub, "p1")).start();
        new Thread(new Producer(pubSub, "p2")).start();
        new Thread(new Producer(pubSub, "p3")).start();
        new Thread(new Consumer(pubSub, "c1")).start();
        new Thread(new Consumer(pubSub, "c2")).start();
       // executorService.shutdown();
    }
}

class Producer implements Runnable {
    PubSub pubSub;
    String name;
    Producer(PubSub pubSub,String name) {
        this.pubSub = pubSub;
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                pubSub.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {
    PubSub pubSub;
    String name;
    Consumer(PubSub pubSub, String name) {
        this.pubSub = pubSub;
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                pubSub.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}