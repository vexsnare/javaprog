package language.threads;


import java.util.LinkedList;
import java.util.List;

/**
 * @author vinay.saini
 * @created 23/07/2020 - 12:36 PM
 */


class MyBlockingQueue {
    LinkedList<Integer> list = new LinkedList<>();
    private int size;
    MyBlockingQueue(int size) {
        this.size = size;
    }
    public synchronized void add(int n) throws InterruptedException {
        while (list.size() == n) {
            wait();
        }
        list.add(n);

    }

    public synchronized void remove() throws InterruptedException {
        while (list.size() == 0) {
            wait();
        }
        list.remove();
        notifyAll();

    }
}

public class LearnBlockingQueue {

}
