package language.threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author vinay.saini
 * @created 23/07/2020 - 11:57 AM
 */

class Task implements  Runnable {
    private String task;
    Task(String name) {
        this.task = name;
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        for(int i  = 0; i < 10; i++) {
            if(i == 0) {
                System.out.println("Initialization time : " + simpleDateFormat.format(new Date()) + " Task : " + task);
            } else {
                System.out.println("Running time : " + simpleDateFormat.format(new Date()) + " Task : " + task);
            }
        }
    }
}

public class LearnThreadPool {
    public static void main(String[] args) {
        Runnable r1 = new Task("Task 1");
        Runnable r2 = new Task("Task 2");
        Runnable r3 = new Task("Task 3");
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.shutdown();
    }
}
