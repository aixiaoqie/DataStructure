package com.ssw.binarytree.topic;

import com.ssw.binarytree.Node;

public class GenerateTree {
    /**
     * 通过有序数组生成平衡搜索二叉树
     * <p>
     * 递归过程比较简单：
     * 用有序数组中间的树生成搜索二叉树的头节点，然后用这个数左面的树生成左子树，右面的树生成右子树
     */
    public Node generateTree(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }
        return generateTreeBySortArr(sortArr, 0, sortArr.length - 1);
    }

    private Node generateTreeBySortArr(int[] sortArr, int start, int end) {
        int mid = (start + end) / 2;
        Node head = new Node(mid);
        head.left = generateTreeBySortArr(sortArr, start, mid - 1);
        head.right = generateTreeBySortArr(sortArr, mid + 1, end);
        return head;
    }
}
