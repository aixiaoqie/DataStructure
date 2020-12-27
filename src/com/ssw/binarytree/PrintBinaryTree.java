package com.ssw.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的按层打印 以及zigzag打印
 */
public class PrintBinaryTree {

    /**
     * 按层打印
     *
     * @param head
     */
    public void printBylevel(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        int level = 1;
        Node last = head;
        Node nlast = null;
        queue.offer(head);
        System.out.print("level " + level++ + ":");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nlast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nlast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                System.out.print("\nlevel " + level++ + ":");
                last = nlast;
            }
        }
        System.out.println();
    }





    public static void main(String[] args) {
        Node head = new Node(1);
        Node left1_1 = new Node(2);
        Node right1_1 = new Node(3);
        head.left = left1_1;
        head.right = right1_1;
        Node right2_4 = new Node(5);
        Node left2_1 = new Node(100);
        left1_1.left = left2_1;
        right1_1.right = right2_4;
        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        printBinaryTree.printBylevel(head);
    }
}
