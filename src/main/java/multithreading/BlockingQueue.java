package multithreading;

/*
A blocking queue is defined as a queue which blocks the caller of the enqueue method if there's no more capacity to add the new item being enqueued.
Similarly, the queue blocks the dequeue caller if there are no items in the queue.
Also, the queue notifies a blocked enqueuing thread when space becomes available and
a blocked dequeuing thread when an item becomes available in the queue.
 */
public class BlockingQueue<T> {
    int size = 0;
    T[] elements;
    int capacity;
    int head = 0;
    int tail = 0;

    Object lock = new Object();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
    }

    public void enqueue(T o) throws InterruptedException {
        synchronized (lock) {
            while (size == capacity) {
                lock.wait();
            }
            if (tail == capacity) {
                tail = 0;
            }
            elements[tail] = o;
            tail++;
            size++;

            // there might be consumer waiting for element
            lock.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        T result;
        synchronized (lock) {
            while (size == 0) {
                lock.wait();
            }
            if (head == capacity) head = 0;

            result = elements[head];
            head++;
            size--;
            lock.notifyAll();
        }
        return result;
    }

}

class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Integer> bq = new BlockingQueue<>(4);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    bq.enqueue(new Integer(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("T1 Enqueued " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 32; i++) {
                try {
                    bq.enqueue(new Integer(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("T2 Enqueued " + i);
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 32; i++) {
                try {
                   Integer r = bq.dequeue();
                    System.out.println("Dequeued " + r);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
