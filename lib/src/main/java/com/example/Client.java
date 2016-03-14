package com.example;

/**
 * Created by hero on 2016/3/14.
 */
public class Client {
    public static void main(String args[]) {
        HanMeimei hanMeimei = new HanMeimei();
        LiLei liLei = new LiLei();
        hanMeimei.setLiLei(liLei);
        hanMeimei.study();
        hanMeimei.shopping();
    }
}
