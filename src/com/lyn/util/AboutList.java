package com.lyn.util;

public class AboutList {

     class ListNode<T> {
         public int data;
         public ListNode next;

     }


    private static class Node {
        int value;
        Node next;
        Node rand;

        Node(int val) {
            value = val;
        }

    }

    //反转链表
    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode nextTemp = null;
        while (curr != null) {
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //判断是否是回文链表
    public static boolean isPalidrome3(ListNode node) {
        if (node == null) {
            return true;
        }
        ListNode n1 = node;
        ListNode n2 = node;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
        }
        n2 = n2.next.next;//运行完这个循环后n1在中点，n2在链表的最后一个节点


        n2 = n1.next;//n2连接到右半部分的第一个
        n1.next = null;//将链表从终点处断开
        ListNode temp = null;
        //该循环相当于翻转链表的右半部分
        while (n2 != null) {
            temp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = temp;
        }
        temp = n1;//
        n2 = node;//n2赋值为初始头结点
        boolean result = true;
        //遍历判断是否回文
        while (n1 != null && n2 != null) {
            if (n1 != n2) {
                result = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = temp.next;
        temp.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = temp;
            temp = n1;
            n1 = n2;
        }
        return result;
    }
//    public static ListNode ListPartition(ListNode node,int pivot){
//
//
//
//
//    }

    public static Node copyListWithRand(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;

        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : next;
            cur = next;
        }
        return res;
    }

    //判断两个链表是否相交，并返回相交的第一个节点 （主函数）
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null || loop2 == null) {//无环情况
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }


    //判断链表是否有环，并获取第一个入环节点
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //无环情况，返回两个链表的第一个相交节点
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;//用于计算两条链表的长度差
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {//如果尾结点不相等 表明两个链表必然不相交
            return null;
        }
        cur1 = n > 0 ? head1 : head2;//cur1等于长链表；
        cur2 = cur1 != head1 ? head1 : head2;//cur2等于短链表；
        n = Math.abs(n);
        while (n != 0) {//长链表先走n步，让2个链表处于相等长度
            n--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //有环情况
    public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
             cur1 = head1;
             cur2 = head2;
            int n = 0;//用于计算两条链表的长度差
            while (cur1.next != null) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != null) {
                n--;
                cur2 = cur2.next;
            }
            if (cur1 != cur2) {//如果尾结点不相等 表明两个链表必然不相交
                return null;
            }
            cur1 = n > 0 ? head1 : head2;//cur1等于长链表；
            cur2 = cur1 != head1 ? head1 : head2;//cur2等于短链表；
            n = Math.abs(n);
            while (n != 0) {//长链表先走n步，让2个链表处于相等长度
                n--;
                cur1 = cur1.next;
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }


    }


}
