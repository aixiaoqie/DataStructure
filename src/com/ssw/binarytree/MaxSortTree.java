package com.ssw.binarytree;

/**
 * 二叉树头节点为head，求此二叉树的最大搜索二叉树
 */
public class MaxSortTree {


    public Node getSortTree(Node head) {
        int[] arr = new int[3];
        return posOrder(head, arr);
    }

    private Node posOrder(Node head, int[] arr) {
        if (head == null) {
            arr[0] = 0;
            arr[1] = Integer.MIN_VALUE;
            arr[2] = Integer.MAX_VALUE;
            return null;
        }
        int value = head.value;
        Node left = head.left;
        Node right = head.right;
        Node lBST = posOrder(left, arr);
        int lSize = arr[0];
        int lMin = arr[1];
        int lMax = arr[2];

        Node rBST = posOrder(right, arr);
        int rSize = arr[0];
        int rMin = arr[1];
        int rMax = arr[2];

        arr[1] = Math.min(value, lMin);
        arr[2] = Math.max(value, rMax);

        if (left == lBST && right == rBST && lMax < value && rMin > value) {
            arr[0] = lSize + rSize + 1;
            return head;
        }
        arr[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
    }


}
