package com.example;

/**
 * Created by hero on 2016/3/14.
 */
public class LiLei implements Observer {

    @Override
    public void update(String message) {
        System.out.println("���׹۲쵽�¶�̬��" + message);
    }
}
