package language.threads;

/**
 * @author vinay.saini
 * @created 23/07/2020 - 10:03 AM
 */
public class ThreadByClass extends Thread {

    public void run() {
        System.out.println("Running thread");
    }

    public static void main(String[] args) {
        ThreadByClass threadByClass = new ThreadByClass();
        //threadByClass.setDaemon(true);
        threadByClass.start();
        System.out.println(threadByClass.isDaemon());
    }
}
