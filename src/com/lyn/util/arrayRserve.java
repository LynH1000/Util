package com.lyn.util;

public class arrayRserve {
    private static int[] arrayRserve(int [] a) {
        int temp=0;
        int length=a.length;
        for (int i = 0; i < a.length; i++) {
            temp =a[i];
            a[i]=a[length-1-i];
            a[length-1-i]=temp;

        }
        return a;
    }

}


