package com.example;

/**
 * Created by hero on 2016/3/14.
 */
public class LiLei implements ILiLei {

    @Override
    public void update(String message) {
        System.out.println("李雷观察到韩梅梅的新动向：" + message);
    }
}
