package design;

/**
 * Created by vinaysaini on 11/14/16.
 */
public class Main {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        obj.print();
        Singleton obj2 = Singleton.getInstance();
        obj.print();
    }
}
