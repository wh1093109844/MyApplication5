package com.example;

/**
 * Created by hero on 2016/3/14.
 */
public class HanMeimei implements IHanMeimei {

    private LiLei liLei;

    @Override
    public void study() {
        String message = "��÷÷��ʼѧϰ��";
        System.out.println(message);
        liLei.update(message);
    }

    @Override
    public void shopping() {
        String message = "��÷÷��ʼ�����";
        System.out.println(message);
        liLei.update(message);
    }

    public LiLei getLiLei() {
        return liLei;
    }

    public void setLiLei(LiLei liLei) {
        this.liLei = liLei;
    }
}
