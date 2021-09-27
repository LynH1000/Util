package com.lyn.util;

public class BinaryTree {

    static class Node<V> {
        V value;
        Node left;
        Node right;
    }

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


}
