package language.threads;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author vinay.saini
 * @created 23/07/2020 - 6:44 PM
 */
public class ProducerConsumerProblem {
    static BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        Producer producer = new Producer(blockingDeque);
        Consumer consumer = new Consumer(blockingDeque);
        Thread t1  = new Thread(producer);
        Thread t2  = new Thread(() -> {
            while (true) {
                try {
                    blockingDeque.take();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(t1);
        executorService.execute(t2);
    }
}

class Producer implements Runnable {
    BlockingDeque<String> blockingDeque;
    Random random = new Random();
    Producer(BlockingDeque<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                String value = String.valueOf(random.nextInt());
                System.out.println("Produced: " + value);
                blockingDeque.put(value);
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable {
    BlockingDeque<String> blockingDeque;
    Consumer(BlockingDeque<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Consumed: " +  blockingDeque.take());
                Thread.sleep(150);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}