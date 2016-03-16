package com.example.hero.myapplication;

import android.util.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observer;
import java.util.Set;

/**
 * Created by hero on 2016/3/16.
 */
public class ObserverManager {
    private static final String TAG = ObserverManager.class.getSimpleName();
    private static ObserverManager observerManager;

    private Map<String, Set<Observer>> oberversMap;

    private ObserverManager() {
        oberversMap = new HashMap<>();
    }

    public static ObserverManager getInstance() {
        if (observerManager == null) {
            observerManager = new ObserverManager();
        }
        return observerManager;
    }

    /**
     * 注册观察者
     * @param tag
     * @param observer
     */
    public void registerObserver(String tag, Observer observer) {
        Log.i(TAG, "==================registerObserver================");
        Log.i(TAG, "TAG:" + tag);
        Log.i(TAG, "observer:" + observer);
        if (oberversMap == null) {
            oberversMap = new HashMap<>();
        }
        Set<Observer> observerSet = oberversMap.get(tag);
        if (observerSet == null) {
            observerSet = new HashSet<>();
            oberversMap.put(tag, observerSet);
        }
        observerSet.add(observer);
    }

    public void registerObserver(Observer observer) {
        registerObserver(observer.getClass().getName(), observer);
    }

    public void notifyObserver(String tag, Object obj) {
        Log.i(TAG, "=============notifyObserver=============");
        Log.i(TAG, "TAG:" + tag);
        Log.i(TAG, "Object:" + obj);
        Set<Observer> observerSet = oberversMap.get(tag);
        if (observerSet == null || observerSet.isEmpty()) {
            Log.i(TAG, "not observer");
        }
        for(Observer observer : observerSet) {
            observer.update(null, obj);
        }
    }

    public void notifyObserver(Object obj) {
        Set<String> keySet = oberversMap.keySet();
        for (String key : keySet) {
            notifyObserver(key, obj);
        }
    }
}
