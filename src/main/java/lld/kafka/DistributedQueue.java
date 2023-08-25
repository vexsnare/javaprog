package lld.kafka;

import java.util.HashMap;
import java.util.Map;

public class DistributedQueue {

    Map<String, Topic> topicMap = new HashMap<>();
    public void createTopic(String name) {

        Topic topic = new TopicImpl(100);
        topicMap.put(name, topic);
    }

    public void publishMessage(String topic, String message) throws InterruptedException {
        if(topicMap.containsKey(topic)) {
            topicMap.get(topic).putMessage(message);
        } else {
            System.out.printf("No such topic");
        }
    }

    public String retrieveMessage(String topic) throws InterruptedException {
        String message = "";
        if(topicMap.containsKey(topic)) {
            message = topicMap.get(topic).getMessage();
        }
        else  {
            System.out.printf("No such topic");
        }
        return message;
    }

}
