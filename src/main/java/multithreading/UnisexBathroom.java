package multithreading;

import java.util.Objects;

public class UnisexBathroom {

    String inUseBy;
    int inTotal;

    void maleUseBathroom(String name) throws InterruptedException {
        synchronized (this) {
            while (Objects.equals(inUseBy, "female") || inTotal == 3) {
                wait();
            }
            inUseBy = "male";
            inTotal++;

        }
        useBathroom(name);
        synchronized (this) {
            inTotal--;
            if (inTotal == 0) {
                inUseBy = "none";
            }
            notifyAll();
        }
    }

    void femaleUseBathroom(String name) throws InterruptedException {
        synchronized (this) {
            while (Objects.equals(inUseBy, "male")  || inTotal == 3) {
                wait();
            }
            inUseBy = "female";
            inTotal++;
        }
        useBathroom(name);
        synchronized (this) {
            inTotal--;
            if (inTotal == 0) {
                inUseBy = "none";
            }
            notifyAll();
        }
    }

    void useBathroom(String name) throws InterruptedException {
        System.out.println(name + " is using bathroom");
        Thread.sleep(1000);
        System.out.println(name + " done using bathroom");
    }
}

class UnisexBathroomTest {
    public static void main(String[] args) throws InterruptedException {

        final UnisexBathroom unisexBathroom = new UnisexBathroom();

        Thread female1 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread female2 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Priya");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male1 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("John");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male2 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Bob");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male3 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Anil");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male4 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Rahul");
                } catch (InterruptedException ie) {

                }
            }
        });

        female1.start();
        male1.start();
        male2.start();
        female2.start();
        male3.start();
        male4.start();

        female1.join();
        male1.join();
        male2.join();
        female2.join();
        male3.join();
        male4.join();

    }

}
