package src.com.ssw.binarytree;

import java.util.HashMap;

/**
 * 在二叉树中找到累加和为指定值k的最长路径长度
 */
public class MaxSubTree {


    public int getMaxLength(Node head, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        return preOrder(head, k, 0, 1, 0, map);
    }

    private int preOrder(Node head, int k, int preSum, int level, int len, HashMap<Integer, Integer> map) {
        if (head == null) {
            return len;
        }
        int curSum = preSum + head.value;//获取从头节点到当前节点的累加和
        if (!map.containsKey(curSum)) {
            map.put(curSum, level);
        }
        if (map.containsKey(curSum - k)) {
            len = Math.max(len, level - map.get(curSum - k));
        }
        len = preOrder(head.left, k, curSum, level + 1, len, map);
        len = preOrder(head.right, k, curSum, level + 1, len, map);
        if (level == map.get(curSum)) {
            map.remove(curSum);
        }
        return len;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node left1_1 = new Node(2);
        Node right1_1 = new Node(3);
        Node left2_1 = new Node(4);
        head.left = left1_1;
        head.right = right1_1;
        left1_1.left = left2_1;
        MaxSubTree subTree = new MaxSubTree();
        int maxLength = subTree.getMaxLength(head, 7);
        System.out.println(maxLength);
    }


}

