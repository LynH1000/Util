package com.lyn.util;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String url = in.next();
        String input[] = url.split("\\,");
        StringBuilder result = new StringBuilder();
        if (input.length==0){
            System.out.println("/");
            return;
        }
        result.append("/");
        result.append(input[0]);
        result.append("/");
        result.append(input[1]);
        System.out.println(result.toString().replaceAll("//+","/"));
    }
}
