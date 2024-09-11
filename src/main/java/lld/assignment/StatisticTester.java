package lld.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */
public class StatisticTester {

    static float calculateMean(int[] ar) {
        int sum = Arrays.stream(ar).sum();
        return sum * 1.0f / ar.length;
    }

    static float calculateVariance(int[] ar) {
        float mean = calculateMean(ar);
        int[] squares = Arrays.stream(ar).map((x) -> x*x).toArray();
        int sumOfSquare = Arrays.stream(squares).sum();

        return sumOfSquare * 1.0f / ar.length - mean * mean;
    }

    public static void main(String[] args) throws InterruptedException {
        Statistics statistics = new StatisticWriteHeavy();


        int[] input = IntStream.range(0, 100).toArray();
        int[] evenInput = Arrays.stream(input).filter((x) -> x%2 == 0).toArray();
        int[] oddInput = Arrays.stream(input).filter((x) -> x%2 != 0).toArray();

        Thread t1 = new Thread(new EventProducer(evenInput, statistics));
        Thread t2 = new Thread(new EventProducer(oddInput, statistics));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(statistics.mean());
        System.out.println(calculateMean(input));

        System.out.println(statistics.variance());
        System.out.println(calculateVariance(input));

    }

    static class EventProducer implements Runnable {
        int [] events;
        Statistics statistics;

        EventProducer(int[] ar, Statistics statistics) {
            this.events = ar;
            this.statistics = statistics;
        }
        @Override
        public void run() {
            for(int num: this.events) {
                statistics.event(num);
            }
        }
    }
}
