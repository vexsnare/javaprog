import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by vinaysaini on 11/17/16.
 */

class Test {

    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    static Map<String, String> m = new HashMap<>();


    Test() {
        executorService.scheduleAtFixedRate(Test::consume,2,2,TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        new Test();
        synchronized (m) {
            m.put("k1", "v1");
            m.put("k2", "v2");
            m.put("k3", "v3");
        }
    }

    static void consume() {
        System.out.println("#");
        synchronized (m) {
            for (String k : m.keySet()) {
                System.out.println(k + " " + m.get(k));
                m.remove(k);
                break;
            }
        }
    }
}
