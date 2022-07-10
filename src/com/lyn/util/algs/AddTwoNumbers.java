package com.lyn.util.algs;




/*两数相加*/
public class AddTwoNumbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode sumHead = new ListNode(0);
        ListNode sumNode = sumHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {  // 循环条件：两个数有一个没完
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            //<公式>   当前位 = (A 的当前位 + B 的当前位 + 进位carry) % 10
            int sum = x + y + carry;
            carry = sum / 10;
            sumNode.next = new ListNode(sum % 10);
            sumNode = sumNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return sumHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
