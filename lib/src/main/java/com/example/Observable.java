package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hero on 2016/3/14.
 */
public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

}
