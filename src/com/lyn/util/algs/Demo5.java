package com.lyn.util.algs;

import java.util.HashMap;
import java.util.Map;

/*
* 给你一个字符串S，一个字符串T。请在字符串S里面找出：包含T所有字母的最小子串。
示例：
输入：S = “ADOBECODEBANC”, T = “ABC”
输出：”BANC”

说明：
如果S中不存在这样的子串，则返回空字符串“”；
如果S中存在这样的子串，我们保证它是唯一答案；*/
public class Demo5 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        //1.维护两个map记录窗口中的符合条件的字符以及need的字符
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();//need中存储的是需要的字符以及需要的对应的数量
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
        int left = 0, right = 0;//双指针
        int count = 0;//count记录当前窗口中符合need要求的字符的数量,当count == need.size()时即可shrik窗口
        int start = 0;//
        int len = Integer.MAX_VALUE;//len用来记录最终窗口的长度，并且以len作比较，淘汰选出最小的substring的len

        //一次遍历找“可行解”
        while (right < s.length()) {
            //更新窗口
            char c = s.charAt(right);
            right++;//窗口扩大
            // window.put(c,window.getOrDefault(c,0)+1);其实并不需要将s中所有的都加入windowsmap，只需要将need中的加入即可
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    count++;
                }
            }
            //System.out.println****Debug位置
            //shrink左边界，找符合条件的最优解
            while (count == need.size()) {
                if (right - left < len) {//不断“打擂”找满足条件的len最短值,并记录最短的子串的起始位序start
                    len = right - left;
                    start = left;
                }
                //更新窗口——这段代码逻辑几乎完全同上面的更新窗口
                char d = s.charAt(left);
                left++;//窗口缩小
                if (need.containsKey(d)) {
                    //window.put(d,window.get(d)-1);——bug：若一进去就将window对应的键值缩小，就永远不会满足下面的if，while也会一直执行，知道left越界，因此，尽管和上面对窗口的处理几乎一样，但是这个处理的顺序还是很关键的！要细心！
                    if (need.get(d).equals(window.get(d))) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);

                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            char[] ss = s.toCharArray();
            char[] ts = t.toCharArray();
            int[] map = new int[256];
            for (char c : ts) {
                map[c]++;
            }
            int tLen = ts.length;
            int L = 0, R = 0;
            int minLen = -1, ansl = -1, ansr = -1;
            while (R != ss.length) {
                map[ss[R]]--;
                if (map[ss[R]] >= 0) {
                    tLen--;
                }
                if (tLen == 0) {
                    while (map[ss[L]] < 0) {
                        map[ss[L++]]++;
                    }
                    //map[ss[L]]==0, 收集答案，因为后续的L再扩就不满足tLen==0;
                    if (minLen == -1 || minLen > R - L + 1) {
                        minLen = R - L + 1;
                        ansl = L;
                        ansr = R;
                    }
                    tLen++;
                    map[ss[L++]]++;
                }
                R++;
            }
            return minLen == -1 ? "" : s.substring(ansl, ansr + 1);
        }
    }
 /*模板
 滑动窗口算法框架
  void slidingWindow(String s, String t) {
      Map<Character, Integer> need = new HashMap<>();
      Map<Character, Integer> window = new HashMap<>();
      for (char c : t.toCharArray())
          need.put(c, need.getOrDefault(c, 0) + 1);
      int left = 0, right = 0;
      int valid = 0;
      while (right < s.length()) {
          // c 是将移入窗口的字符
          char c = s.charAt(right);
          // 右移窗口
          right++;
          // 进行窗口内数据的一系列更新

          *//*** debug 输出的位置 ***//*
          System.out.println("window: [" + left + "," + right + ")");
          *//********************//*

          // 判断左侧窗口是否要收缩
          while (window needs shrink){
              // d 是将移出窗口的字符
              char d = s[left];
              // 左移窗口
              left++;
              // 进行窗口内数据的一系列更新

          }
      }
  }
    # Step 4 - 情况1
            # 如果题目的窗口长度固定：用一个if语句判断一下当前窗口长度是否达到了限定长度
            # 如果达到了，窗口左指针前移一个单位，从而保证下一次右指针右移时，窗口长度保持不变,
            # 左指针移动之前, 先更新Step 1定义的(部分或所有)维护变量
            if 窗口长度达到了限定长度:
                # 更新 (部分或所有) 维护变量
                # 窗口左指针前移一个单位保证下一次右指针右移时窗口长度保持不变

            # Step 4 - 情况2
            # 如果题目的窗口长度可变: 这个时候一般涉及到窗口是否合法的问题
            # 如果当前窗口不合法时, 用一个while去不断移动窗口左指针, 从而剔除非法元素直到窗口再次合法
            # 在左指针移动之前更新Step 1定义的(部分或所有)维护变量
            while 不合法:
                # 更新 (部分或所有) 维护变量
                # 不断移动窗口左指针直到窗口再次合法

        # Step 5: 返回答案
  */
}