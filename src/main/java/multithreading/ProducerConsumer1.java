package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Using blocking queue
public class ProducerConsumer1 {
    private static BlockingQueue<Integer> bq = new BlockingQueue<>(100);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> producers = new ArrayList<>();
        List<Thread> consumers = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10000000; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    bq.enqueue(Integer.valueOf(finalI));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        ExecutorService executorService2 = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1000000; i++) {
            executorService2.execute(() -> {
                try {
                    System.out.println("Item : " + bq.dequeue());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService2.shutdown();
        executorService.shutdown();
    }
}
