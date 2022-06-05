package com.lyn.util;


public class CheckIP {

    public static void main(String[] args) {
        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";

        CheckIP checkIP = new CheckIP();

        checkIP.validIPAddress(queryIP);
    }

    public void validIPAddress(String queryIP) {
        if (queryIP == null) {
            return;
        }
        //ipv4
        if (queryIP.contains(".")) {
            String[] x = queryIP.split("\\.");
            if (x.length < 3) {
                System.out.println("Neither");
                return;
            }
            for (String s : x) {
                if (s == null) {
                    return;
                }
                Integer integer = Integer.parseInt(s);
                String s1 = integer.toString();
                if (!s1.equals(s)) {
                    System.out.println("Neither");
                    return;
                }
                if (integer > 255) {
                    System.out.println("Neither");
                    return;
                }
                if (s.length() > 3) {
                    System.out.println("Neither");
                    return;
                }
            }
            System.out.println("IPv4");
        }

        //ipv6
        if (queryIP.contains(":")) {
            String[] x = queryIP.split("\\:");
            if (x.length != 8) {
                System.out.println("Neither");
                return;
            }
            for (String s : x) {
                if (s == null) {
                    System.out.println("Neither");
                    return;
                }
                if (s.length() > 4) {
                    System.out.println("Neither");
                    return;
                }

            }
            System.out.println("IPv6");
        }
    }
}
