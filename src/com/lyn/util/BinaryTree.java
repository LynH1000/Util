package com.lyn.util;

import java.util.*;

public class BinaryTree {


    //按照先序方式 序列化二叉树
    public static String serialByPre(Node head) {
        if (head == null) return "#_";
        String result = head.value + "_";
        result += serialByPre(head.left);
        result += serialByPre(head.right);
        return result;
    }

    //根据字符串进行反序列号 生成二叉树
    public static Node reconByPre(String result) {
        String[] value = result.split("_");
        Queue queue = new LinkedList();
        for (String v : value
        ) {
            queue.add(v);
        }
        return reconByPreO(queue);

    }

    private static Node reconByPreO(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = reconByPreO(queue);
        head.right = reconByPreO(queue);
        return head;
    }

    //判断是否是平衡二叉树
    public static boolean isBalancedTree(Node head) {
        return balanceProcess(head).isBalanced;
    }

    private static ReturnType balanceProcess(Node head) {

        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = balanceProcess(head.left);
        ReturnType rightData = balanceProcess(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }

    //递归中序遍历
    public static void process(Node head, List<Node> list) {
        if (head == null) {
            return;
        }
        process(head.left, list);
        list.add(head);
        process(head.right, list);
    }


    //判断是否是完全二叉树
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null, r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && !(l == null && r == null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) leaf = true;
        }


        return true;
    }


    //检查是否是平衡二叉树
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

    public int compareTo(Node cur, Node next) {
        return cur.value - next.value > 0 ? 1 : -1;
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

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int hei) {
            isBalanced = isB;
            height = hei;
        }
    }

    static class Node<V> {
        int value;
        Node left;
        Node right;

        public Node(Integer value) {
        }


        public int compareTo(Node current, Node previous) {
            return current.value - previous.value >= 0 ? 1 : -1;
        }
    }

}
