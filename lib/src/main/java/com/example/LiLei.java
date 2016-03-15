package com.example;

/**
 * Created by hero on 2016/3/14.
 */
public class LiLei implements Observer {

    @Override
    public void update(String message) {
        System.out.println("李雷观察到新动态：" + message);
    }
}
