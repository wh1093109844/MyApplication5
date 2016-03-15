package com.example;

/**
 * Created by hero on 2016/3/14.
 */
public class HanMeimei extends Observable implements IHanMeimei {

    @Override
    public void study() {
        String message = "韩梅梅开始学习了";
        System.out.println(message);
        notifyObservers(message);
    }

    @Override
    public void shopping() {
        String message = "韩梅梅开始逛街了";
        System.out.println(message);
        notifyObservers(message);
    }
}
