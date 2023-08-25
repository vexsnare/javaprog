package lld.kafka;

import java.util.List;

public interface Consumer {
    public void subscribe(String topic);
    public void pollMessage(String topic) throws InterruptedException;
}
