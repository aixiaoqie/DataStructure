package com.ssw.binarytree.topic;

import com.ssw.binarytree.Node;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 判断树是否为完全二叉树
     * <p>
     * 问题：给定一个二叉树的头节点head，已知其中没有重复值的节点，判断树是否为完全二叉树
     * <p>
     * 解：通过以下标准会使判断过程变得简单且易实现
     * 1.按层遍历二叉树，从每层的左边向右边依次遍历所有节点；
     * 2.如果当前节点有孩子，但没有左孩子，直接返回false；
     * 3.如果当前节点并不是左右孩子全有，那之后的节点必须全部为叶子节点，否则返回false；
     * 4.遍历过程中如果不返回false，遍历结束后返回true。
     */
    public boolean isCBF(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            /**
             * l == null && r != null ,当前节点有孩子，但没有左孩子，直接返回false
             * leaf && (l != null || r != null)，到此层循环当前节点有左右节点说明不是叶子节点，返回false
             */
            if (leaf && (l != null || r != null) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true; //当前节点没有右节点，将leaf标识设为true，表示之后的节点必须全部为叶子节点
            }
            /*

            与上面等效
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
            if (l == null || r == null) {
                leaf = true; 
            }
            */

        }
        return true;
    }

}
