package com.lyn.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        int requestP = 0;
        int releaseP = 0;
        Scanner in = new Scanner(System.in);
        //总命令行数
        int sum = Integer.parseInt(in.nextLine());
        //内存池初始化
        char[] memPool = new char[100];
        for (int i = 0; i < 100; i++) {
            memPool[i] = '0';
        }
        Map<Integer, Integer> memRecrord = new HashMap<>();

        for (int i =1; i <= sum; i++) {
            int cap = 0;
            String temp = in.nextLine().toString();
            String status = temp.split("\\=")[0];
            int size = Integer.parseInt(temp.split("\\=")[1]);
            if (status.equals("REQUEST")) {
                request(size, memRecrord, requestP, releaseP, cap, memPool);

            }
            if (status.equals("RELEASE")) {
                release(size, memRecrord, releaseP, cap, memPool);

            }

        }
    }

    public static void request(int requestSize, Map<Integer, Integer> memRecrord, int requestP, int releaseP, int cap, char[] memPool) {
        if (requestSize == 0) {
            System.out.println("error");
            return;
        }
        if (requestP + requestSize <= 100) {
            memRecrord.put(requestP, requestSize);
            System.out.println(requestP);
            cap = requestP + requestSize;
            for (int i = requestP; i < cap; i++) {
                memPool[i] = '1';
            }
            return;
        }
        if (requestP + requestSize > 100 && releaseP != 0) {
            int linkSize = 0;
            int linkP = -1;
            for (int i = 0; i < releaseP; i++) {
                if (memPool[i] == '0') {
                    ++linkSize;
                    if (linkSize == requestSize) {
                        break;
                    }
                } else {
                    linkSize = 0;
                    linkP = i;
                }
            }
            if (linkSize>=requestSize){
                memRecrord.put(linkP+1,linkSize);
                System.out.println(linkP+1);
                for (int i = linkP+1; i <linkP+linkSize+1 ; i++) {
                    memPool[i] = '1';
                }
            }
            else {
                System.out.println("error");
            }
        }else {
            System.out.println("error");
        }


    }

    public static void release(int releaseAddr, Map<Integer, Integer> memRecrord, int releaseP, int cap, char[] memPool) {

        if (memRecrord.containsKey(releaseAddr)){
            Integer releaseSize =  memRecrord.get(releaseAddr);
            for (int i = 0; i < releaseSize; i++) {
                memPool[i]='0';
                releaseP=releaseAddr+releaseSize;
            }
        }else {
            System.out.println("error");
        }


    }


}
