package com.ssw.binarytree;

import java.util.HashMap;

/**
 * 二叉树的节点值各不相同，根据先序遍历以及中序遍历结果 生成后序遍历数组
 */
public class GetPostOrder {

    /**
     * 根据当前的先序和中序数组，设置后序数组最右面的值，然后划分出左子树的先序、中序数组，以及右子树的先序中序数组
     * 然后先根据右子树的划分设置好有序数组，再根据左子树的划分，从右面到左面一次设置好后序数组的全部位置。
     */

    public static int[] getPostArr(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = pre.length;
        int[] post = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        setPost(pre, 0, len - 1, in, 0, len - 1, post, len - 1, map);
        return post;

    }

    /**
     * 从右到左依次填好后序数组post
     * postR为后序数组post该填的位置
     * 返回值为post该填入的下一个位置
     *
     * @param postR 为后序数组该填的位置
     */
    private static int setPost(int[] pre, int pL, int pR, int[] in, int iL, int iR, int[] post, int postR, HashMap<Integer, Integer> map) {
        if (pL > pR) {
            return postR;
        }
        post[postR--] = pre[pL];//后序数组最后一个位置对应先序数组第一个位置
        int index = map.get(pre[pL]);//获得中序数组根节点的位置
        postR = setPost(pre, pL + index - iL + 1, pR, in, index + 1, iR, post, postR, map);//右子树的调整
        return setPost(pre, pL + 1, pL + index - iL, in, iL, index - 1, post, postR, map);//左子树的调整

    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] in = new int[]{4, 2, 5, 1, 6, 3, 7};
        //预期结果post={4,5,2,6,7,3,1}
        int[] postArr = getPostArr(pre, in);
        for (int i = 0; i < postArr.length; i++) {
            System.out.print(postArr[i] + " ");
        }
    }
}
