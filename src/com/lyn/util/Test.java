package com.lyn.util;

import java.util.HashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
        String t = "ABDBC";
        Map<Character, Integer> need = new HashMap<>();//need中存储的是需要的字符以及需要的对应的数量
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
        System.out.println(need.toString());
    }
}








