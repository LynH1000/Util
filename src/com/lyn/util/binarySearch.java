package com.lyn.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class binarySearch<i> {
    static int  i=0;

    public static void main(String[] args) {

        int key = 96;
        int a[] = {1,2,3,4,5,6,8,9,10,11,12,13,14,15,17,7,8,3,4,53,6,0,51,1,31};

        System.out.println("result="+rank(key, a));
    }

    private static int rank(int key, int[] a) {
        List list=new LinkedList();
        Iterator it=list.iterator();
        return rank(key, a, 0, a.length - 1);
    }

    private static int rank(int key, int[] a, int lo, int hi) {
        i++;
        System.out.println(" "+lo+" "+hi);
        if (lo > hi) {
            return i;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return i;
        }

    }
}
