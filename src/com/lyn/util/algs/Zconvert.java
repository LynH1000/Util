package com.lyn.util.algs;


public class Zconvert {
    public String solution(String s, int numRows) {

        int n = s.length();
        int high = numRows;
        int t = 2 * high - 2;
        int weight = (n / t) * (high - 1);

        char[][] c = new char[weight][high];
        int x = 0;
        int y = 0;


        for (int i = 0; i < n; i++) {
            //如果该位置的字符还没满足一个周期
            if (i % t < high - 1) {
                x++;
            } else {
                x--;
                y++;
            }
            c[x][y] = s.charAt(i);

        }
        StringBuffer result = new StringBuffer();

        for (char[] w : c) {
            for (char h : w) {
                result.append(h);
            }
        }
        return result.toString();

    }
}
