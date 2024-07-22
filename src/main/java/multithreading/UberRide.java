package multithreading;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberRide {
    int republicans = 0;
    int democrats = 0;
    ReentrantLock lock = new ReentrantLock();
    private Semaphore demsWaiting = new Semaphore(0);
    private Semaphore repubsWaiting = new Semaphore(0);

    public void seatRepublicans() throws InterruptedException, BrokenBarrierException {
        boolean isRideReady = false;
        lock.lock();
        republicans++;

        if(republicans == 4) {
            repubsWaiting.release(3);
            republicans -= 4;
            isRideReady = true;
        } else if(republicans == 2 && democrats >= 2) {
            repubsWaiting.release(1);
            republicans -= 2;
            demsWaiting.release(2);
            democrats -= 2;
            isRideReady = true;
        } else {
            lock.unlock();
            System.out.println("unlocked");
            repubsWaiting.acquire();
            System.out.println("acquired by " + Thread.currentThread().getName());
        }
        seated();
      //  barrier.await();
        System.out.println("Barrier released for " + Thread.currentThread().getName());
        if(isRideReady) {
            drive();
            lock.unlock();
        }
    }

    public void seatDemocrats() throws InterruptedException, BrokenBarrierException {
        boolean rideLeader = false;
        lock.lock();

        democrats++;

        if (democrats == 4) {
            demsWaiting.release(3);
            democrats -= 4;
            rideLeader = true;
        } else if (democrats == 2 && republicans >= 2) {
            demsWaiting.release(1);
            repubsWaiting.release(2);
            rideLeader = true;
            democrats -= 2;
            republicans -= 2;
        } else {
            System.out.println("unlocked");
            lock.unlock();
            demsWaiting.acquire();
            System.out.println("acquired by " + Thread.currentThread().getName());
        }

        seated();
    //    barrier.await();
        System.out.println("Barrier released for " + Thread.currentThread().getName());

        if (rideLeader == true) {
            drive();
            lock.unlock();

        }
    }
    public void seated() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "  seated");
        System.out.flush();
    }
    public void drive() {
        System.out.println(Thread.currentThread().getName() + "  Driving");
    }

    public static void main(String[] args) throws InterruptedException {


        final UberRide uberSeatingProblem = new UberRide();
        Set<Thread> allThreads = new HashSet<Thread>();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        uberSeatingProblem.seatDemocrats();
                    } catch (InterruptedException ie) {
                        System.out.println("We have a problem");

                    } catch (BrokenBarrierException bbe) {
                        System.out.println("We have a problem");
                    }

                }
            });
            thread.setName("Democrat_" + (i + 1));
            allThreads.add(thread);

            Thread.sleep(50);
        }

        for (int i = 0; i < 14; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        uberSeatingProblem.seatRepublicans();
                    } catch (InterruptedException ie) {
                        System.out.println("We have a problem");

                    } catch (BrokenBarrierException bbe) {
                        System.out.println("We have a problem");
                    }
                }
            });
            thread.setName("Republican_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(20);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }
}
