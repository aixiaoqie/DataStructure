package com.ssw.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的先序 中序 后序遍历结果两两结合 重构二叉树
 */
public class ReBuildTree {

    /**
     * 先序 + 中序
     */
    public Node preInBuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return preIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public Node preIn(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij,
                      Map<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }
        Node head = new Node(preorder[pi]);
        int index = Integer.parseInt(map.get(preorder[pi]).toString());
        head.left = preIn(preorder, pi + 1, pi + index - ii, inorder, ii, index - 1, map);
        head.right = preIn(preorder, pi + index - ii + 1, pj, inorder, index + 1, ij, map);
        return head;
    }
}
