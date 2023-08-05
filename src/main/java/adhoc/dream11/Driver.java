package adhoc.dream11;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        DistributedQueue distributedQueue = new DistributedQueue();
        distributedQueue.createTopic("Topic1");
        distributedQueue.createTopic("Topic2");

        Producer p1 = new ProducerImpl("Producer1", distributedQueue);
        Producer p2 = new ProducerImpl("Producer2", distributedQueue);

        Consumer c1 = new ConsumerImpl("Consumer1", distributedQueue);
        Consumer c2 = new ConsumerImpl("Consumer2", distributedQueue);
        Consumer c3 = new ConsumerImpl("Consumer3", distributedQueue);
        Consumer c4 = new ConsumerImpl("Consumer4", distributedQueue);
        Consumer c5 = new ConsumerImpl("Consumer5", distributedQueue);

        c1.subscribe("Topic1");
        c2.subscribe("Topic1");
        c3.subscribe("Topic1");
        c4.subscribe("Topic1");
        c5.subscribe("Topic1");


        c1.subscribe("Topic2");
        c3.subscribe("Topic2");
        c4.subscribe("Topic2");

        p1.sendMessage("Topic1", "Message1");
        p1.sendMessage("Topic1", "Message2");
        p2.sendMessage("Topic1", "Message3");
        p1.sendMessage("Topic2", "Message4");
        p2.sendMessage("Topic2", "Message5");


    }

}
