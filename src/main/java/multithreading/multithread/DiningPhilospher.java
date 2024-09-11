package multithreading.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */
public class DiningPhilospher {

    DiningPhilospher() {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }
    Semaphore philospher = new Semaphore(4);
    Semaphore[] forks = new Semaphore[5];

    private void dine(int id) throws InterruptedException {
        System.out.println("Eating " + id);
        Thread.sleep(1000);
    }

    public void start(int id) throws InterruptedException {
        while (true) {
            philospher.acquire();
            forks[id].acquire();
            forks[(id + 1) % 4].acquire();
            dine(id);
            forks[(id + 1) % 4].release();
            forks[id].release();
            philospher.release();
        }
    }

    public static void main(String[] args) {
        DiningPhilospher dp = new DiningPhilospher();
        Thread t1 = new Thread(() -> {
            try {
                dp.start(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                dp.start(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                dp.start(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                dp.start(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(t1);
        es.submit(t2);
        es.submit(t3);
        es.submit(t4);
    }
}



