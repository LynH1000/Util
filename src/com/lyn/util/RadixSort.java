package com.lyn.util;

import edu.princeton.cs.algs4.StdOut;

//桶排序
public class RadixSort {
    public static void main(String[] args) {
       // StdOut.println(getDigit(1,2)+"-------");
        int i=getDigit(55755,3);
        System.out.println(i+"-------");
    }


    public static void radixsort(int arr[]){
        if (arr == null||arr.length<2) {
            return;
        }
        radixsort(arr,0,arr.length-1,maxbits(arr));
    }

    private static void radixsort(int[] arr, int L, int R, int digit) {
        final int radix=10;
        int i=0,j=0;
        int bucket[]=new int [R-L+1];
        for (int d = 1; i <= digit; i++) {
            int count[]=new int [radix];
            for (i=L;i<=R;i++){
                j=getDigit(arr[i],d);
            }
            for ( i = 1; i < radix; i++) {
                count[i]=count[i]+count[i-1];
            }
            for ( i = R; i >=L; i++) {
                j=getDigit(arr[i],d);
                bucket[count[j]-1]=arr[i];
                count[j]--;
            }
        }


    }

    private static int getDigit(int i, int d) {

        return ((i/((int)Math.pow(10,d-1)))%10);
    }

    private static int maxbits(int[] arr) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        int res=0;


        return res;
    }

}
