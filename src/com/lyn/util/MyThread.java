package com.lyn.util;

public class MyThread implements Runnable {
    private int ticketNums = 10;


    public MyThread() {
    }

    @Override
    public void run() {
        while (true) {
            if (ticketNums < 1) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNums--);
        }
    }
}


