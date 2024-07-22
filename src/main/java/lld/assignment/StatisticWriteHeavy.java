package lld.assignment;

/**
 * [WriteHeavy] Implementation
 * We don't want to take lock - non-blocking operation
 */
import java.util.concurrent.atomic.AtomicReference;

public class StatisticWriteHeavy implements Statistics {
    private static class State {
        final long count;

        final double sum;

        final double sumOfSquares;

        final int min;

        final int max;

        State(long count, double sum, double sumOfSquares, int min, int max) {
            this.count = count;
            this.sum = sum;
            this.sumOfSquares = sumOfSquares;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * holds the current state.
     */
    private final AtomicReference<State> state;

    public StatisticWriteHeavy() {
        this.state = new AtomicReference<>(
                new State(0, 0.0, 0.0, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    @Override
    public void event(int n) {
        State prev, next;
        do {
            prev = state.get();
            next = new State(prev.count + 1, prev.sum + n, prev.sumOfSquares + n * n,
                    Math.min(prev.min, n), Math.max(prev.max, n));
        } while (!state.compareAndSet(prev, next));
        // CAS loop ensures that the update is applied only if no other thread has modified the state concurrently.
    }

    @Override
    public int min() {
        return state.get().min;
    }

    @Override
    public int max() {
        return state.get().max;
    }

    @Override
    public float mean() {
        State s = state.get();
        return s.count == 0 ? 0.0f : (float) (s.sum / s.count);
    }

    @Override
    public float variance() {
        State s = state.get();
        if (s.count == 0) {
            return 0.0f;
        }
        double mean = s.sum / s.count;
        return (float) ((s.sumOfSquares / s.count) - (mean * mean));
    }
}
