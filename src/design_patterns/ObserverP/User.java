package design_patterns.ObserverP;

public class User implements Observer {
    String name = null;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notifyObserver() {
        System.out.println("User " + this.name + " is notified");
    }

    public void subscribe(Observable observable) {
        observable.registerObserver(this);
    }


    public void unsubscribe(Observable observable) {
        observable.removeObserver(this);
    }
    
}
