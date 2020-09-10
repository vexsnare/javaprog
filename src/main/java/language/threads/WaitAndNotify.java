package language.threads;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author vinay.saini
 * @created 27/08/2020 - 6:56 PM
 */

class EvenOddPrinter {
    volatile boolean isOddPrinted = false;
    synchronized public void printOdd(int number) throws InterruptedException {
        while (isOddPrinted) {
            wait();
        }
        System.out.println("Running " + Thread.currentThread().getName());
        System.out.println(number);
        isOddPrinted = true;
        notify();
    }

    synchronized public void printEven(int  number) throws InterruptedException {
        while (!isOddPrinted) {
            wait();
        }
        System.out.println("Running " + Thread.currentThread().getName());
        System.out.println(number);
        isOddPrinted = false;
        notify();
    }
}

class EvenOddTask implements Runnable {
    int number = 1;
    EvenOddPrinter evenOddPrinter;
    EvenOddTask(EvenOddPrinter evenOddPrinter, int initNumber) {
        this.evenOddPrinter = evenOddPrinter;
        this.number = initNumber;
    }
    @Override
    public void run() {
        while (true) {
            try {
                if(number % 2 != 0)
                    evenOddPrinter.printOdd(number);
                else
                    evenOddPrinter.printEven(number);
                number += 2;
                Thread.sleep(1000);
            } catch (Exception e){};
        }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) {
        EvenOddPrinter evenOddPrinter = new EvenOddPrinter();
        EvenOddTask oddTask = new EvenOddTask(evenOddPrinter, 1);
        EvenOddTask evenTask = new EvenOddTask(evenOddPrinter, 2);
        Thread t1 = new Thread(oddTask, "Odd Thread");
        Thread t2 = new Thread(evenTask, "Even Thread");
        t1.start();
        t2.start();
    }

}
