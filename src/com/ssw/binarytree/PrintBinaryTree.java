package com.ssw.binarytree;

import java.util.*;

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


    /**
     * 二叉树的zigzag按层打印
     * <p>
     * 使用双向队列dq
     * 原则1：如果从左到右，从dq头部弹出节点，弹出的节点没有孩子节点，不用放入；
     * 有孩子节点，先让左孩子从尾部进，再让右孩子尾部进入dq
     * 原则2：如果从右到左，从dp尾部弹出节点，弹出的节点没有孩子节点，不用放入；
     * 有孩子节点，先让右孩子从头部进，再让左孩子从头部进。
     */


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        Node last = root;
        Node nlast = null;
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (!deque.isEmpty()) {
            Node node = null;
            if (flag) {
                node = deque.pollFirst();
                list.add(node.value);
                System.out.print(node.value + " ");
                if (node.left != null) {
                    nlast = nlast == null ? node.left : nlast;
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    nlast = nlast == null ? node.right : nlast;
                    deque.offerLast(node.right);
                }
            } else {
                node = deque.pollLast();
                list.add(node.value);
                System.out.print(node.value + " ");
                if (node.right != null) {
                    nlast = nlast == null ? node.right : nlast;
                    deque.offerFirst(node.right);
                }
                if (node.left != null) {
                    nlast = nlast == null ? node.left : nlast;
                    deque.offerFirst(node.left);
                }
            }
            if (node == last) {
                last = nlast;
                nlast = null;
                flag = !flag;
                List<Integer> copyList = new ArrayList<>();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    copyList.add((Integer) it.next());
                    it.remove();
                }
                res.add(copyList);
            }
        }
        return res;
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
//        printBinaryTree.printBylevel(head);
        List<List<Integer>> lists = printBinaryTree.levelOrder(head);
    }
}
