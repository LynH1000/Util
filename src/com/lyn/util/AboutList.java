package com.lyn.util;

public class AboutList {

    public class ListNode<T> {
        public int data;
        public ListNode next;

    }
    //反转链表
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
    //判断是否是回文链表
    public static boolean isPalidrome3(ListNode node){
        if (node == null) {
            return true;
        }
        ListNode n1=node;
        ListNode n2=node;
        while (n2.next!=null&&n2.next.next!=null){
            n1=n1.next;
            n2=n2.next.next;//运行完这个循环后n1在中点，n2在链表的最后一个节点
        }


        n2=n1.next;//n2连接到右半部分的第一个
        n1.next=null;//将链表从终点处断开
        ListNode temp=null;
        //该循环相当于翻转链表的右半部分
        while (n2!=null){
            temp=n2.next;
            n2.next=n1;
            n1=n2;
            n2=temp;
        }
        temp=n1;//
        n2=node;//n2赋值为初始头结点
        boolean result=true;
        //遍历判断是否回文
        while (n1!=null&&n2!=null){
            if(n1!=n2){
                result=false;
                break;
            }
            n1=n1.next;
            n2=n2.next;
        }
        n1=temp.next;
        temp.next=null;
        while (n1!=null){
            n2=n1.next;
            n1.next=temp;
            temp=n1;
            n1=n2;
        }
        return result;
    }

}
