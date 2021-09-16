package com.lyn.util;

public class AboutList {

    public class ListNode<T> {
        public int data;
        public ListNode next;

    }

    public static ListNode  reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode nextTemp =null;
        while (curr!=null){
                nextTemp=curr.next;
                curr.next=prev;
                prev=curr;
                curr.next=nextTemp;
        }
        return prev;
    }
    public static boolean isPalidrome3(ListNode node){
        if (node == null) {
            return true;
        }
        ListNode n1=node;
        ListNode n2=node;
        while (n2.next!=null&&n2.next.next!=null){
            n1=n1.next;
            n2=n2.next.next;
        }
        n2=n1.next;//n2连接到右半部分的第一个
        n1.next=null;
        ListNode n3=null;

        boolean result=true;






        return result;
    }

}
