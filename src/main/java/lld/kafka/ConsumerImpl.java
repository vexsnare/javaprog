package lld.kafka;

import java.util.ArrayList;
import java.util.List;

public class ConsumerImpl implements Consumer {

    String name;
    DistributedQueue distributedQueue;
    List<String> subscribedTopics;
    public ConsumerImpl(String name, DistributedQueue distributedQueue) {
        this.distributedQueue = distributedQueue;
        this.subscribedTopics = new ArrayList<>();
        this.name = name;
    }
    @Override
    public void subscribe(String topic) {
        subscribedTopics.add(topic);
    }

    @Override
    public void pollMessage(String topic) throws InterruptedException {
        
        new Thread(() -> {
            try {
                while (true) {
                    String message = distributedQueue.retrieveMessage(topic);
                    System.out.printf("Message received ", message);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    // consume
}
