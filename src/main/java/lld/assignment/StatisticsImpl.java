package lld.assignment;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.StampedLock;

/**
 * [ Ready-Heavy ]
 * Solution is optimized for more concurrent read - it used optimistic nonblocking read lock
 * if write contention is high we can use regular readWrite lock but that will block read operation when write is happening
 */
public class StatisticsImpl implements Statistics {

    private final AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
    private final AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
    private final AtomicLong count = new AtomicLong();
    private final DoubleAdder sum = new DoubleAdder();
    private final DoubleAdder sumOfSquares = new DoubleAdder();

    // Using stamped lock instead of readWrite for non-blocking i/o
    private final StampedLock lock = new StampedLock();

    /**
     * consumes events using thread-safe variables
     * @param n
     */
    @Override
    public void event(final int n) {
        /**
         * These values (count, sum, sumOfSquares) are thread safe for atomic operation individually,
         * since we want to write a set of values, hence to ensure consistency among them we have to acquire lock
         */
        long stamp = lock.writeLock();
        try {
            count.incrementAndGet();
            sum.add(n);
            sumOfSquares.add(n*n);

            min.accumulateAndGet(n, Math::min);
            max.accumulateAndGet(n, Math::max);
        } finally {
            lock.unlock(stamp);
        }
    }

    /**
     *
     * @return min value calculated so far
     */
    @Override
    public int min() {
        return min.get();
    }

    /**
     * @return max value calculated so far
     */
    @Override
    public int max() {
        return max.get();
    }

    /**
     * takes optimistic lock to reads value
     * if write happens concurrently then it will interrupt so we re-validate stamp value and take regular read lock
     * Read fresh values again inside validation block
     * @return mean
     */
    @Override
    public float mean() {
        long stamp = lock.tryOptimisticRead();
        long currentCount = count.get();
        double currentSum = sum.sum();

        // validating optimistic locking
        if(!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentCount = count.get();
                currentSum = sum.sum();
            } finally {
                lock.unlockRead(stamp);
            }
        }

        if(currentCount == 0) return 0.0f;
        return (float) (currentSum / currentCount);
    }

    /**
     * It uses a formula of Sigma(x^2 - mean)^2/n => (Sigma x^2)/N - (Sigma(x)/N)^2
     * @return float variance
     */
    /**
     * takes optimistic lock to reads value
     * if write happens concurrently then it will interrupt so we re-validate stamp value and take regular read lock
     * Read fresh values again inside validation block
     * @return mean
     */
    @Override
    public float variance() {
        long stamp = lock.tryOptimisticRead();
        long currentCount = count.get();
        double currentSum = sum.sum();
        double currentSumOfSquares = sumOfSquares.sum();

        // validating optimistic locking to check if there was an interrupt
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentCount = count.get();
                currentSum = sum.sum();
                currentSumOfSquares = sumOfSquares.sum();
            } finally {
                lock.unlockRead(stamp);
            }
        }

        if (currentCount == 0) {
            return 0.0f;
        }
        double mean = currentSum / currentCount;
        return (float) ((currentSumOfSquares / currentCount) - (mean * mean));
    }
}
