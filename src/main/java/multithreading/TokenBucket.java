package multithreading;


import java.util.ArrayList;
import java.util.List;

class TokenBucketTest {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(5);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    tokenBucket.getToken();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.setName("Thread " + i);
            threadList.add(t);
        }

        for(Thread t: threadList) {
            t.start();
        }

        for(Thread t: threadList) {
            t.join();
        }
    }

}


public class TokenBucket {
    int MAX_TOKEN;
    private long lastRequestTime = System.currentTimeMillis();
    long possibleTokens = 0;
    public TokenBucket(int maxTokens) {
        this.MAX_TOKEN = maxTokens;
    }

    synchronized void getToken() throws InterruptedException {
        possibleTokens = (System.currentTimeMillis() - lastRequestTime) / 1000;

        if (possibleTokens > MAX_TOKEN) {
            possibleTokens = MAX_TOKEN;
        }

        if (possibleTokens == 0) {
            Thread.sleep(1000);
        } else {
            possibleTokens --;
        }
        lastRequestTime = System.currentTimeMillis();
        System.out.printf("Granting : %s\n", Thread.currentThread().getName());

    }
}