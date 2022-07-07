package com.lyn.util;

import java.util.Arrays;

public class MergeSort {
    //归并排序
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 4, 9};
        int L = 0, R = arr.length - 1;
        process(arr, L, R);
        Arrays.stream(arr).forEach(System.out::println);
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
        int point2 = mid + 1;
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


    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    protected int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }


}
