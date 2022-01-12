package com.lyn.util;

public class Test {

    public static void main(String[] args) {
        byte[] test=hex2ba("59");
        for (byte a:test) {
            System.out.println(a);
        }
    }

    public static byte[] hex2ba(String hexString) {
        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hexString.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
