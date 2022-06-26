package com.lyn.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input[] = in.nextLine().split("\\W+");
        String match = in.nextLine();
        StringBuilder result = new StringBuilder();
        TreeSet<String> treeSet = new TreeSet();
        for (String s : input) {
            if (s.startsWith(match)) {
                treeSet.add(s);
            }
        }
        if (treeSet.size() == 0) {
            System.out.println(match);
            return;
        }
        for (String s : treeSet) {
            result.append(s).append(" ");
        }
        System.out.println(result.toString());
    }

    public String create32() {// 32位唯一编码
        String s = "";
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
        s = sdf.format(d);
        Random r = new Random();
        for (int i = 0; i < 12; i++) {
            s = s + r.nextInt(10);
        }
        return s;
    }
}
