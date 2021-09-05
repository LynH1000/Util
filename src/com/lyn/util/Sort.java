package com.lyn.util;

public class Sort {

    public static void main(String[] args) {

        int arr[] = {1, 7, 2, 5, 6, 8, 1, 4, 5, 6, 8, 9};
        int[] arry2 = selectionSort(arr);
    }

    /*
     * 选择排序
     * */
    private static int[] selectionSort(int[] arr) {
        int arry3[] = arr;
        int temp, min = 0;
        for (int i = 0; i < arry3.length; i++) {
            min = i;
            for (int j : arry3) {
                if (arry3[j] < arry3[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = arry3[i];
                arry3[i] = arry3[min];
                arry3[min] = temp;
            }
        }
        return arry3;
    }

    /*
     * 冒泡排序
     * */
    public static int[] bubbleSort(int arr[]) {
        int arry3[] = arr;
        int temp = 0;
        for (int i = 0; i < arry3.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (arry3[j + 1] < arry3[j]) {
                    temp = arry3[j];
                    arry3[j] = arr[j + 1];
                    arry3[j + 1] = temp;
                }
            }
        }
        return arry3;
    }
    /*
    * 插入排序
    * */
    public static void insertionSort(int arr[]){
        if (arr.length<2||arr==null){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >0&&arr[j]>arr[j+1] ; j--) {
                swap(arr,j,j+1);
            }
        }

    }
    //归并排序






    /*
     * 快速排序
     * */

    /*
     * 堆排序
     * */

    /*
     * hash排序
     * */


    public static void swap(int[] arr, int j, int i) {

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}
