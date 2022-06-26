package com.lyn.util;

import java.util.HashMap;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String queryIP = in.nextLine();

        validIPAddress(queryIP);
    }

    public static void validIPAddress(String queryIP) {

        if (queryIP == null) {
            return;
        }
        //ipv4
        if (queryIP.contains(".")) {
            String[] x = queryIP.split("\\.");
            System.out.println(x.length);
            if (x.length < 4) {
                System.out.println("NO");
                return;
            }
            for (String s : x) {
                if (s == null || s.equals("")) {
                    System.out.println("NO");
                    return;
                }
                Integer integer = Integer.parseInt(s);
                String s1 = integer.toString();
                if (!s1.equals(s)) {
                    System.out.println("NO");
                    return;
                }
                if (integer > 255) {
                    System.out.println("NO");
                    return;
                }

            }
            System.out.println("YES");
        }

    }
}








