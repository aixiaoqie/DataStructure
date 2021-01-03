package com.ssw.binarytree.topic;

import com.ssw.binarytree.Node;

public class FindNearParentNode {

    /**
     * 在二叉树找到两个节点的最近公共祖先
     * <p>
     * 给定一个二叉树的头节点head，以及这棵树两个节点o1，o2，返回o1，o2的最近公共祖先节点
     * <p>
     * 解：
     * 后序遍历二叉树，假设遍历到的当前节点为cur，先处理两颗子树
     * 处理左子树返回节点为left，处理右子树返回right
     * 1.如果发现cur为null，或者o1，o2，则返回cur；
     * 2.如果left和right都为null，说明cur的子树中没有发现过o1或者o2，返回null；
     * 3.如果left和right都不为null，说明左子树发现过o1或o2，右子树也发现过o2或o1.
     * 说明o1与o2在向上的过程中，首次在cur相遇，返回cur；
     * 4.如果left和right有一个为null，另一个不为null，假设不为空的记为node
     * 此时node有2种可能：①node是o1或者o2中的一个 ②node已经是o1，o2的最近公共祖先
     * 不管哪种情况，直接返回node。
     */
    public Node getParent(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = getParent(head.left, o1, o2);
        Node right = getParent(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
/**
 * 进阶：如果查询两个节点的最近公共祖先的操作十分频繁，想让单条查询的查询时间减少
 */

}
