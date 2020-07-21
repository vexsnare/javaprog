package language.synchronize;

/**
 * @author vinay.saini
 * @created 20/07/2020 - 9:49 PM
 */
public class MyStaticCounter {
    private static int count = 0;
    public static synchronized void add(int value) {
        count += value;
    }
}
