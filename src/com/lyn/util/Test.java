package com.lyn.util;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        HashMap hashMap=new HashMap<>();
        hashMap.put("1",1);
        hashMap.put("1",2);
        hashMap.put("1",3);

        System.out.println(hashMap.get("1"));
    }

}






