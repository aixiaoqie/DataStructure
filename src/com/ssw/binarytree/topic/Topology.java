package com.ssw.binarytree.topic;

import com.ssw.binarytree.Node;

/**
 * 拓扑问题
 */
public class Topology {

    /**
     * 判断t1树是否包含t2树的全部拓扑结构
     * <p>
     * 若t1的节点树为N,t2的节点数为M,时间复杂度O(N*M)
     * <p>
     * 找到两颗树值一样的节点，同时进行先序遍历
     */

    public boolean contains(Node t1, Node t2) {

        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    public boolean check(Node h, Node t2) {
        if (t2 == null) {
            return true;
        }
        if (h == null || h.value != t2.value) {
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }


    // TODO: 2020/12/27  判断t1的子树是否是t2的拓扑结构  KMP算法

}
