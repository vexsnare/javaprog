package designpatterns.ObserverP;

/**
 * Article:
 *https://dzone.com/articles/observer-pattern-java
 * InBuilt API:
 * https://dzone.com/articles/observer-design-pattern-java
 */
public class App {
    public static void main(String[] args) {
        User u1 = new User("Vinay");
        User u2 = new User("Rahul");
        User u3 = new User("Karan");
        User u4 = new User("Ajeet");

        RedDress redDress = new RedDress();

        u1.subscribe(redDress);
        u2.subscribe(redDress);
        u3.subscribe(redDress);

        u1.unsubscribe(redDress);
        u4.subscribe(redDress);

        redDress.updateStatus("Available");


    }
}
