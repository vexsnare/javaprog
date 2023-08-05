package adhoc.dream11;

public interface Producer {
    public void sendMessage(String topic, String message) throws InterruptedException;
}
