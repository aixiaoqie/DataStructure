package com.ssw.binarytree.topic;

import com.ssw.binarytree.Node;

/**
 * 求二叉树节点间的最大距离
 * <p>
 * 要求二叉树的节点数为N,时间复杂度为O(N)
 */
public class GetMaxDistance {

    /**
     * 一个以head为头的二叉树上，最大距离只有一下三种情况 ：
     * 1. head的左子树的最大距离
     * 2. head的右子树的最大距离
     * 3. head的左子树上距离h.left最远的距离 + 1(head) + h的右子树上距离head.right的最远的距离
     * 三个值最大的就是二叉树最远距离
     * <p>
     * 后序遍历,在二叉树的每个子树上执行下面步骤：
     * 处理左子树得到两个信息，左子树的最大距离 lMax,左子树上距离head.left的最远距离 maxFromLeft;
     * 同理，处理右子树得到两个信息，右子树的最大距离 rMax,右子树上距离head.right的最远距离 maxFromRight;
     * maxFromLeft + 1 + maxFromRight就是跨head节点的最大距离
     * 三个中的最值作为head树上的最大距离返回；
     * maxFromLeft+1就是head左子树上离head最远的点到head的距离，maxFromRight+1就是右子树上离head最远的点到head的距离。
     * 选两者中最大的一个作为head树上距离head最远的距离返回。
     */
    public int maxDistance(Node head) {
        int[] record = new int[1];
        return posOrder(head, record);
    }

    public int posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left, record);
        int maxFromLeft = record[0];
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;//记录cur为头的树，距离cur最远的距离。
        return Math.max(Math.max(lMax, rMax), curNodeMax);

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node left1_1 = new Node(2);
        Node right1_1 = new Node(3);
        head.left = left1_1;
        head.right = right1_1;
        Node right2_4 = new Node(5);
        Node left2_1 = new Node(4);
        left1_1.right = left2_1;
        right1_1.right = right2_4;
        GetMaxDistance distance = new GetMaxDistance();
        int i = distance.maxDistance(head);
        System.out.println(i);
    }
}
