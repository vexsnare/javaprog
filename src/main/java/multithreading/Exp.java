package multithreading;

import java.util.concurrent.locks.ReentrantLock;

class EOPrinter implements Runnable {
    int count;
    ReentrantLock reentrantLock = new ReentrantLock();
    EOPrinter (int count) {
        this.count = count;
    }
    public void printEven() {
        System.out.println("Even printer " + count);
    }

    public void printOdd() {
        System.out.println("Odd printer " + count);
    }

    public void increment() {
        count++;
    }

    @Override
    public void run() {
        while (true) {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " ");
            printEven();
            increment();
            reentrantLock.notify();
        }
    }
}
public class Exp {
    public static void main(String[] args) throws InterruptedException {
        EOPrinter eoPrinter = new EOPrinter(1);
        Thread thread1 = new Thread(eoPrinter, "t1");
        Thread thread2 = new Thread(eoPrinter, "t2");
        thread1.start();
        thread1.join(1000);
        thread2.start();
      //  thread1.join();
        //System.out.println("Hello world");
    }
}
