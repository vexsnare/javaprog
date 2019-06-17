package designPatterns.Singleton;

/**
 * Created by vinaysaini on 11/14/16.
 */

class Singleton {
    private static Singleton instance = null;
    private Singleton(){};
    public static Singleton getInstance() {
        if(null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

    void display() {
        System.out.println("This is a random text");
    }
}