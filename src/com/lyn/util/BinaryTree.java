package com.lyn.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    public static boolean CheckBst(Node head) {
        List<Node> list = new ArrayList<>();
        process(head, list);

        Iterator<Node> iter = list.iterator();
        Node current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current, previous) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
    public int compareTo(Node cur,Node next) {
        return  cur.value-next.value> 0 ? 1 :-1;
    }
    /*
     * 递归方式遍历二叉树
     * */
    public static void f(Node head) {
        //1
        if (head == null) {
            return;
        }
        //1
        //2
        f(head.left);
        //2
        //3
        f(head.right);
        //3
    }

    //先序遍历
    public static void preOrderUnRecur(Node head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");

                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
        }
        System.out.println();
    }

    //中序遍历
    public static void inOrderUnRecur(Node head) {
        System.out.println("in-order ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {

                if (head != null) {//将所有左边界进栈
                    stack.push(head);
                    head = head.left;
                } else {//弹出就打印 然后head变成右孩子
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }


    //后序遍历
    public static void posOrderUnRecur1(Node head) {
        System.out.println("pos-order ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();//收集栈

            stack1.add(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value + " ");
            }
        }

        System.out.println();
    }

    //后序遍历
    public static void posOrderUnRecur(Node head) {
        System.out.println("pos-order ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.println(stack.pop().value + "  ");
                    head = c;
                }
            }
        }
        System.out.println();
    }

    static class Node<V> {
        int value;
        Node left;
        Node right;


        public int compareTo(Node current, Node previous) {
            return current.value - previous.value >= 0 ? 1 : -1;
        }
    }

    public static void process(Node head, List<Node> list) {
        if (head == null) {
            return;
        }
        process(head.left, list);
        list.add(head);
        process(head.right, list);
    }

}
