package com.lyn.util;

/*
* 水仙花数
* */
public class Narcissistic {


    public static void main(String[] args) {
        int a,b,c=0;
        for (int i = 100; i <=999 ; i++) {
            a=i/100;
            b=i/10-a*10;
            c=i-a*100-b*10;
            if (((a*a*a)+(b*b*b)+(c*c*c))==i){
                System.out.println(i);
            }

        }

    }
}
