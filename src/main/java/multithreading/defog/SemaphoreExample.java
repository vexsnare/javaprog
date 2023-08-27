package multithreading.defog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore permits = new Semaphore(3);
        ExecutorService service = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i -> service.execute(new Task(permits)));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }
}

class Task implements Runnable {

    Semaphore permits;
    Task(Semaphore semaphore) {
        this.permits = semaphore;
    }
    @Override
    public void run() {
        permits.acquireUninterruptibly();
        // do something
        permits.release();
    }
}