package com.lyn.util;

import java.util.*;

/*
* 给你一个字符串S，一个字符串T。请在字符串S里面找出：包含T所有字母的最小子串。
示例：
输入：S = “ADOBECODEBANC”, T = “ABC”
输出：”BANC”

说明：
如果S中不存在这样的子串，则返回空字符串“”；
如果S中存在这样的子串，我们保证它是唯一答案；*/
public class Demo5 {
    int[] s = new int[26];
    int[] t = new int[26];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    }

    public String solution(String S, String T) {
        if (S == null || S == "" || T == null || T == "" || S.length() < T.length()) {
            return "";
        }


        //将目标字符串指定字符的出现次数记录
        for (int i = 0; i < T.length(); i++) {
            t[T.charAt(i) - 'A']++;
        }

        for (int i = 0; i < S.length(); i++) {
            s[S.charAt(i) - 'A']++;
        }
        //分别为左指针，右指针，最小长度(初始值为一定不可达到的长度)
        //已有字符串中目标字符串指定字符的出现总频次以及最小覆盖子串在原字符串中的起始位置
        int left = 0, right = 0, min = S.length() + 1, count = 0, start = 0;

        while (right < s.length) {
            for (int i = 0; i < s.length; i++) {
                right++;
                if (right<s.length&&check()) {


                    //cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);

                }
            }


        }


        return "";
    }


    public boolean check() {

        for (int i = 0; i < s.length - 1; i++) {

            if (t[i] < s[i]) {
                return false;
            }
        }
        return true;
    }


}