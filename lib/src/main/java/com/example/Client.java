package com.example;

/**
 * Created by hero on 2016/3/14.
 */
public class Client {
    public static void main(String args[]) {
        HanMeimei hanMeimei = new HanMeimei();
        LiLei liLei = new LiLei();
        Jim jim = new Jim();
        hanMeimei.addObserver(liLei);
        hanMeimei.addObserver(jim);
        hanMeimei.study();
        hanMeimei.shopping();
    }
}
