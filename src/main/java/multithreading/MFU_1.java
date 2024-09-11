package multithreading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import multithreading.defog.ReEntrantLock;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */
public class MFU_1 {
    int size;
    ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<Integer, AtomicInteger> freqMap = new ConcurrentHashMap<>();
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    AtomicInteger count = new AtomicInteger();

    MFU_1(int maxSize) {
        size = maxSize;
        scheduledExecutorService.scheduleAtFixedRate(this::cleanUp, 1, 1, TimeUnit.SECONDS);
    }

    public Integer get(int key) {
        return hashMap.get(key);
    }

    public void add(int key, int value) {
        hashMap.put(key, value);
        freqMap.computeIfPresent(key, (k, v) -> new AtomicInteger()).incrementAndGet();
    }

    private void cleanUp() {
        System.out.println("Hi");
        if(freqMap.size() > size) {
            int maxK = -1;
            int freq = -1;
            for (Map.Entry<Integer, AtomicInteger> e : freqMap.entrySet()) {
                if(e.getValue().get() > freq) {
                    maxK = e.getKey();
                    freq = e.getValue().get();
                }
            }
            freqMap.remove(maxK);
        }
    }

    public static void main(String[] args) {
        MFU_1 mfu1 = new MFU_1(5);


    }
}
