package design;

/**
 * Created by vinaysaini on 11/14/16.
 */
class Singleton {
    private static Singleton instance = null;
    private int count = 0;
    private Singleton(){}
    public  static  Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }
    public int getCount() {
        return count++;
    }
}