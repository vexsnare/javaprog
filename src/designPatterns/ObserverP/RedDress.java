package designPatterns.ObserverP;

import java.util.ArrayList;

public class RedDress implements Observable {
    ArrayList<Observer> observers = new ArrayList<>();
    String state = "Out of stock";

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).notifyObserver();
        }
    }

    public void updateStatus(String status) {
        this.state = status; // available
        notifyObservers();
    }

}
