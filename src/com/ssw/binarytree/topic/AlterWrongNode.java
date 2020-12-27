package com.ssw.binarytree.topic;

import com.ssw.binarytree.Node;

import java.util.Stack;

/**
 * 调整二叉搜索树两个错误的节点
 * <p>
 * 二叉树每个节点值不一样，要求返回长度为2的数组，返回两个错误节点
 */
public class AlterWrongNode {


    /**
     * 若节点结构i正常，二叉排序树的中序遍历的结果为升序排列，所以找到两次降序的位置即可，
     * <p>
     * 第一个错误的节点为第一次降序时较大的节点
     * 第二个错误的节点为最后一次降序时较小的节点
     * <p>
     * 改写一个中序遍历，递归、非递归或者Morris遍历都可以
     */

    //改写非递归遍历
    public Node[] getNodes(Node head) {
        Node[] arr = new Node[2];
        if (head == null) {
            return arr;
        }
        Stack<Node> stack = new Stack<Node>();
        Node pre = null;
        while (!stack.empty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.value > head.value) {
                    arr[0] = arr[0] == null ? pre : arr[0];
                    arr[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return arr;
    }
}
