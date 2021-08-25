package com.lyn.util;

import java.util.Scanner;

public class countDay {

    public static void main(String[] args) {
        //判断某一天是当年的第几天
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] arr = input.split(" ");
        int year, month, day = 0;
        year = Integer.parseInt(arr[0]);
        month = Integer.parseInt(arr[1]);
        day = Integer.parseInt(arr[2]);

        System.out.println(caculateDate(year,month,day));

    }

    private static int caculateDate(int year, int month, int day) {

        int months[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int sum=0;
        for (int i = 0; i < month; i++) {
            sum+=months[i];
        }
        sum+=day;
        if (year%400==0||year%4==0&&year%100!=0){
            if (month>=3){
                sum++;
            }

        }
        return sum;
    }


}
