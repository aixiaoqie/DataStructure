package com.ssw.binarytree.topic;

import com.ssw.binarytree.Node;

/**
 * 后序遍历结果构造二叉树
 */
public class RemakeBinarySortTree {

    /**
     * 问题1：判断无重复值数组的结构是否是搜索二叉树后序遍历的结果
     * <p>
     * 后序遍历，数组最后一个值为树的头节点。比最后一个值小的在二叉树的左面，大的在右面
     * 如果不满足这种情况，说明此数组不是二叉树后序遍历的结果
     */

    public boolean arrIsTreeLastTravel(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return IsLastTravel(arr, 0, arr.length - 1);
    }

    private boolean IsLastTravel(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return IsLastTravel(arr, start, end - 1);
        }
        if (less != more - 1) {
            return false;
        }
        return IsLastTravel(arr, start, less) && IsLastTravel(arr, more, end - 1);
    }

    /**
     * 2.已知整型数组arr没有重复值，且是二叉树后序遍历的结果，根据arr重构二叉树
     */
    public Node refactorTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return refactorBinaryTree(arr, 0, arr.length - 1);
    }

    private Node refactorBinaryTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        Node head = new Node(arr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[start]) {
                less = i; //小于区域最右面值
            } else {
                more = more == end ? i : more; //大于区域最左面值
            }
        }
        head.left = refactorBinaryTree(arr, start, less);
        head.right = refactorBinaryTree(arr, more, end - 1);
        return head;
    }
}
