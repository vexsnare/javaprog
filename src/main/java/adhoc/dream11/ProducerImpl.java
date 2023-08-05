package adhoc.dream11;

public class ProducerImpl implements Producer {
    DistributedQueue distributedQueue;
    String name;

    public ProducerImpl(String name, DistributedQueue distributedQueue) {
        this.name = name;
        this.distributedQueue = distributedQueue;
    }
    @Override
    public void sendMessage(String topic, String message) throws InterruptedException {
        new Thread(() -> {
            try {
                distributedQueue.publishMessage(topic, message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
