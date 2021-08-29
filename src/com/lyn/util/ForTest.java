package com.lyn.util;

import edu.princeton.cs.algs4.Accumulator;

import java.util.Stack;
//测试方法类
public class ForTest {
    private int ain = 0;
    /*
     * 提取一个二进制数最右侧的1
     * */
    int rightOne = ain & (~ain + 1);

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int arr1[] = generateRandomArray(maxSize, maxValue);
            int arr2[] = copyArray(arr1);
            testfunction(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"Nice":"false");
    }



    //被测试方法
    private static void testfunction(int[] arr1) {

    }


    //对照方法
    public static void comparator(int[] arr) {

    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null&&arr2!=null)||(arr1!=null&&arr2==null)) {
            return false;
        }
        if (arr1==null&&arr2==null){
            return true;
        }
        if (arr1.length!=arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    private static int[] copyArray(int[] arr) {
        if (arr==null){
            return null;
        }
        int[] res=new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            res[i]=arr[i];
        }
        return res;
    }


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random());
        }
        return arr;
    }

}
