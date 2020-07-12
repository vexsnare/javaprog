package threading;

/**
 * Created by vinaysaini on 7/12/16.
 */

// we can also extend thread class instead implementing
// Advantage over current approach would be there will be some pre-written method which we can use
public class MultiThreading1 implements Runnable {
    static int count = 0;
    public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("Running thread: "+ Thread.currentThread().getId());
            System.out.println(count++);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread obj = new Thread(new MultiThreading1());
            obj.start();
            obj.sleep(1000);
        }
    }
}
