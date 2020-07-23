package language.threads;

/**
 * @author vinay.saini
 * @created 23/07/2020 - 10:03 AM
 */
public class ThreadByInterface implements Runnable {


    public static void main(String[] args) throws InterruptedException {
        ThreadByInterface threadByInterface = new ThreadByInterface();
        Thread thread1 = new Thread(threadByInterface);
        Thread thread2 = new Thread(threadByInterface);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
