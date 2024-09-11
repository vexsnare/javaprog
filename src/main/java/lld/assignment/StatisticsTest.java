package lld.assignment;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class StatisticsTest {

    public static void main(String[] args) throws InterruptedException {
        final Statistics stats = new StatisticsImpl();

        // Create a thread pool with a fixed number of threads
        int numberOfThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Keep track of expected values for assertions
        AtomicInteger totalEvents = new AtomicInteger(0);
        AtomicLong sumEvents = new AtomicLong(0);
        AtomicInteger minEvent = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger maxEvent = new AtomicInteger(Integer.MIN_VALUE);

        // Create tasks for writing events
        for (int i = 0; i < numberOfThreads / 2; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    int value = (int) (Math.random() * 100);
                    stats.event(value);
                    totalEvents.incrementAndGet();
                    sumEvents.addAndGet(value);
                    minEvent.accumulateAndGet(value, Math::min);
                    maxEvent.accumulateAndGet(value, Math::max);
                }
            });
        }

        // Create tasks for reading statistics
        for (int i = 0; i < numberOfThreads / 2; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    int min = stats.min();
                    int max = stats.max();
                    float mean = stats.mean();
                    float variance = stats.variance();
                    //System.out.println(mean);
                }
            });
        }

        // Shutdown the executor and wait for all tasks to finish
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Assertions on final values
        assert stats.min() == minEvent.get() : "Final Min is incorrect";
        assert stats.max() == maxEvent.get() : "Final Max is incorrect";
        assert stats.mean() == (float) sumEvents.get() / totalEvents.get() : "Final Mean is incorrect";
    }
}
