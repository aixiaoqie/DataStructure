package com.ssw.binarytree;

import java.util.Stack;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraversal {

    class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //递归实现先序遍历
    public void preRootTraversal(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value + "");
        preRootTraversal(head.left);
        preRootTraversal(head.right);
    }

    //递归实现中序遍历
    public void midRootTraversal(Node head) {
        if (head == null) {
            return;
        }
        midRootTraversal(head.left);
        System.out.println(head.value + "");
        midRootTraversal(head.right);
    }

    //递归实现后序遍历
    public void afterRootTraversal(Node head) {
        if (head == null) {
            return;
        }
        afterRootTraversal(head.left);
        afterRootTraversal(head.right);
        System.out.println(head.value + "");
    }


    //非递归实现先序遍历
    public void preRootTraversalNonRecursive(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.empty()) {
                Node cur = stack.pop();
                System.out.println(cur.value + "");
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    //非递归实现中序遍历
    public void midRootTraversalNonRecursive(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            while (!stack.empty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    System.out.println(cur.value + "");
                    cur = cur.right;
                }
            }
        }
    }

    //非递归实现后序遍历
    // 先将二叉树按照 中 右 左的顺序放到另一个栈中，然后从另一个栈中弹出打印实现左 右 头的后序遍历
    public void postRootTraversalNonRecursive(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                help.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!help.isEmpty()) {
                System.out.println(help.pop().value + " ");
            }

        }
    }
}
