package com.lyn.util;

public class MergeSort {
    public static void main(String[] args) {
        int L=0,R = 0;
        int arr[] = new int[0];
        process( L, R,arr);
    }

    private static void process( int[] arr,int L, int R) {
        if (L==R)
            return;
        int mid=L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);

    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int help[];
        int i=0;
        int point1=L;
        int point2=R;
    }


}
