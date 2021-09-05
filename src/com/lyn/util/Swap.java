package com.lyn.util;
/*
* 使用该方法要确保 i地址不等于j地址
*
* */
public class Swap {

    private  int i;
    private  int j;
    private  int a[];

    public Swap() {
    }


    public static void swap(int i, int j, int[] a){
        a[i]=a[i]^a[j];
        a[j]=a[i]^a[j];
        a[i]=a[i]^a[j];

    }


}
