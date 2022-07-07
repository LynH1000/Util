package com.lyn.util.algs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
* 输入：s = "()[]"
输出：true
*
*/
public class IsValid {

    public boolean solution(String s) {

        if (s.length() % 2 == 1) return false;
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            // 将 })] 作为key
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        Stack stack1 = new Stack();
        boolean result = true;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) != stack1.peek() || stack1.peek() == null) {
                    return false;
                }
                stack1.pop();
            } else {
                stack1.push(c);

            }
        }
        return result;
    }
}
