package multithreading;

public class Barrier {
    int count = 0;
    int barrierLimit = 0;
    int released = 0;

    Barrier(int limit) {
        this.barrierLimit = limit;
    }

    public synchronized void await() throws InterruptedException {
        while (count == barrierLimit) wait();
        count++;
        if(count == barrierLimit) {
            notifyAll();
            released = barrierLimit;
        } else {
            while (count < barrierLimit) {
                System.out.println( Thread.currentThread().getName() + " waiting..");
                wait();

            }
        }
        released--;

        if(released == 0) {
            System.out.println("##");
            count = 0;
            notifyAll();
        }
    }
}

class BarrierTest {
    public static void main(String[] args) throws InterruptedException {
        final Barrier barrier = new Barrier(3);
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Enter t1");
                barrier.await();
                System.out.println("Exit t1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Enter t2");
                barrier.await();
                System.out.println("Exit t2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                System.out.println("Enter t3");
                barrier.await();
                System.out.println("Exit t3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
