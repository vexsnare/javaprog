package design;

/**
 * Created by vinaysaini on 11/14/16.
 */
public class Main {
    private void testSingleton() {
        Singleton obj = Singleton.getInstance();
        assert obj.getCount() == 0;
        Singleton obj2 = Singleton.getInstance();
        assert obj2.getCount() == 1;
        Singleton obj3 = Singleton.getInstance();
        assert obj3.getCount() == 2;
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.testSingleton();
    }
}
