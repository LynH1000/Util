package com.lyn.util.algs;


/*奇偶链表*/
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head.next;
        ListNode listNode1 = head;
        ListNode listNode2 = head.next;
        ListNode cur = head.next.next;

        while (listNode2 != null && cur != null) {
            listNode1.next = cur.next.next;
            listNode1 = listNode1.next;
            listNode2.next = cur.next;
            listNode2 = cur;
            cur = cur.next;
        }
        listNode1.next = listNode2;

        return head;
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
