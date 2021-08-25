package com.lyn.util;

public class caculateTwo {
    public static void main(String[] args) {
        System.out.println(cacu(2,5));
    }

    private static int cacu(int a, int b) {
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < b; i++) {
            temp=(temp*10)+a;
            sum+=temp;
        }
        return sum;
    }


}
