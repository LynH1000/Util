package com.lyn.util;

import java.util.LinkedList;
import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        System.out.println("输出行数：");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        LinkedList list=new LinkedList<>();

        list.size();

        int arr[][] = getTri(n);
        printTri(arr);

     //  cacu();
    }



    public static int[][] getTri(int n) {
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = arr[i][i] = 1;
        }
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        return arr;
    }

    public static void printTri(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            //输出杨辉三角数字前的空格
            for (int j = 0; j < arr.length - 1 - i; j++) {
                System.out.print("   ");
            }
            for (int j = 0; j <= i; j++) {
                //打印空格填补空位
                System.out.print("   ");
                System.out.printf("%-3d", arr[i][j]);
            }
            System.out.println();
        }


    }


    private static void cacu() {
        System.out.print("请输入杨辉三角形的行数：");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        //设置杨辉三角的行数
        //int rows = 10;

        for (int i = 0; i < rows; i++) {
            int number = 1;
            //打印空格字符串
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

}
