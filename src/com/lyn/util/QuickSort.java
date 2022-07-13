package com.lyn.util;
/*
* 快速排序
* */
public class QuickSort {

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 7, 5, 4, 3};
        quickSort(arr, 0, arr.length - 1);
            System.out.print(arr.toString());

    }

    public static void quickSort(Integer[] arr, int L, int R) {
        if (L < R) {
            Integer[] p = partition(arr, L, R);// 返回的是相同数值区域的两个边界
            quickSort(arr, L, p[0] - 1);//p[0]是等于部分的左边界
            quickSort(arr, p[1] + 1, R);//p[1]是等于部分的右边界

        }

    }

    public static Integer[] partition(Integer[] arr, int L, int R) {

        // 使用三个指针来将我们的数据分成三类，
        int cur = L;// 这个指向当前数据
        int less = L - 1;// 小数的前面一个
        int more = R + 1;// 大数的后边一个
        int num = arr[arr.length - 1];// 以最后一个值为基准来排出大于和小于
        Integer[] arr1 = new Integer[2];
        while (cur < more) {
            // System.out.println(cur);
            if (arr[cur] > num) {
                swap(arr, cur, --more);
            } else if (arr[cur] < num) {
                swap(arr, cur++, ++less);// less位置增加一个，就会推着cur向后
            } else {
                cur++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            // System.out.print(arr[i]);
        }
        arr1[0] = less + 1;
        arr1[1] = more - 1;
        return arr1;
    }

    // 交换数组位置
    private static void swap(Integer[] arr, Integer m, Integer n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

}
