package com.ssw.binarytree.topic;

import com.ssw.binarytree.Node;

/**
 * 判断树的结构
 */
public class JudgeTree {

    /**
     * 判断树是否为平衡二叉树
     * <p>
     * 平衡二叉树的性质为： 要么为一颗空树，要么任何一个节点的子树高度差绝对值不超过1
     * 给定一个二叉树的头节点，判断是否为平衡二叉树
     * 时间复杂度O(N)
     * 整体过程为二叉树的后序遍历
     */

    public boolean judgeBalanceTree(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];

    }

    private int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);//递归遍历左子树获取左子树的最大高度
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);//递归遍历右子树获取右子树的最大高度
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;//左右子树高度差大于一，全局变量res[0]设为false
        }
        return Math.max(lH, rH);
    }

    /**
     * 判断树是否为搜索二叉树
     * <p>
     * 问题：给定一个二叉树的头节点head，已知其中没有重复值的节点，判断这颗树是否为搜索二叉树
     * <p>
     * 解：判断一颗树是否为搜索二叉树，只要改写二叉树中序遍历，在遍历的过程中判断节点值是否递增即可。
     */
    public boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

}
