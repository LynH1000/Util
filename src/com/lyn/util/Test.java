package com.lyn.util;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String queryIP = "192.168.0.5";
        String[] x = queryIP.split("\\.");
        System.out.println(Arrays.toString(x));


        String str1 = "A,B,C,D";
        String[] arr1 = str1.split(",");
        System.out.println(Arrays.toString(arr1));
    }


}






