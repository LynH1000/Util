package com.lyn.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        int[] t = new int[26];

        String T="AABC";

        //将目标字符串指定字符的出现次数记录
        for (int i = 0; i < T.length(); i++) {
            t[T.charAt(i)-'A']++;
        }
        System.out.println(Arrays.toString(t));
    }



}








