package lld.kafka;

public interface Producer {
    public void sendMessage(String topic, String message) throws InterruptedException;
}
