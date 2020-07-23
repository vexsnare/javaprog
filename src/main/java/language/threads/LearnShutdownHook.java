package language.threads;

/**
 * @author vinay.saini
 * @created 23/07/2020 - 11:05 AM
 */
public class LearnShutdownHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run () {
                System.out.println("Shutdown hook is running");
            }
        });
        System.out.println("Done");
    }
}
