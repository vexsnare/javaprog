package designPatterns.Singleton;

/**
 * Created by vinaysaini on 11/14/16.
 */
public class App {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.display();
    }
}
