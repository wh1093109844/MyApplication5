package com.example;

/**
 * Created by hero on 2016/3/14.
 */
public class HanMeimei extends Observable implements IHanMeimei {

    @Override
    public void study() {
        String message = "��÷÷��ʼѧϰ��";
        System.out.println(message);
        notifyObservers(message);
    }

    @Override
    public void shopping() {
        String message = "��÷÷��ʼ�����";
        System.out.println(message);
        notifyObservers(message);
    }
}
