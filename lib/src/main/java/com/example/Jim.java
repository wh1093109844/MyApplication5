package com.example;

/**
 * Created by hero on 2016/3/15.
 */
public class Jim implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Jim�۲쵽�¶�̬:" + message);
    }
}
