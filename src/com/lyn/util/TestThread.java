package com.lyn.util;

public class TestThread {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        new Thread(myThread, "猫").start();
        new Thread(myThread, "狗").start();
        new Thread(myThread, "我").start();


    }
}

