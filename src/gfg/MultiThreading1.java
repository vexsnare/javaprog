package gfg;

/**
 * Created by vinaysaini on 7/12/16.
 */

// we can also extend thread class instead implementing
// Advantage over current approach would be there will be some pre-written method which we can use
public class MultiThreading1 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("Running thread: "+ Thread.currentThread().getId());
        }
    }
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread obj = new Thread(new MultiThreading1());
            obj.start();
        }
    }
}
