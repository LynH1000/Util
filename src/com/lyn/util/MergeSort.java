package com.lyn.util;

import edu.princeton.cs.algs4.Heap;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int arr[] = {1, 3, 2, 5, 4, 9};
        int L = 0, R = arr.length-1;
        process(arr, L, R);
        Arrays.stream(arr).forEach( System.out::println);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R)
            return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int help[] = new int[R - L + 1];
        int i = 0;
        int point1 = L;
        int point2 =mid+1;
        while (point1 <= mid && point2 <= R) {
            help[i++] = arr[point1] <= arr[point2] ? arr[point1++] : arr[point2++];
        }
        while (point1 <= mid)
            help[i++] = arr[point1++];
        while (point2 <= R)
            help[i++] = arr[point2++];
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }


}
