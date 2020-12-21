package src.com.ssw.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 */
public class BinaryTreeSerializable {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    /**
     * 先序遍历二叉树使其序列化
     * 节点值为空使字符串为 #
     * 节点值结束再后面加 ！
     * 样例 ： 12！3！#！#！
     */

    public String preInorderSerializable(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += preInorderSerializable(head.left);
        res += preInorderSerializable(head.right);
        return res;
    }

    /**
     * 反序列化,
     * 重做先序遍历
     * 将如下字符串反序列化为二叉树
     * "1!2!100!#!#!#!3!#!5!#!#!"
     */
    public Node deSerializableBinaryTree(String s) {
        String[] values = s.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);

    }

    private Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


    /**
     * 层遍历实现序列化
     */
    public String serializeByLevel(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }

        }
        return res;
    }

    /**
     * 层遍历实现反序列化
     */
    public Node reconByLevelString(String str) {
        String[] split = str.split("!");
        int index = 0;
        Node head = new Node(Integer.valueOf(split[index]));
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.left = getNodeByString(split[++index]);
            node.right = getNodeByString(split[++index]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;

    }


    public Node getNodeByString(String value) {
        if (value.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(value));
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node left1_1 = new Node(2);
        Node right1_1 = new Node(3);
        head.left = left1_1;
        head.right = right1_1;
        Node right2_4 = new Node(5);
        Node left2_1 = new Node(100);
        left1_1.left = left2_1;
        right1_1.right = right2_4;
        BinaryTreeSerializable serializable = new BinaryTreeSerializable();
//        String s = serializable.preInorderSerializable(head);
//        System.out.println(s);
        String s1 = "1!2!100!#!#!#!3!#!5!#!#!";
        Node tree = serializable.reconByLevelString(s1);

        String s = serializable.serializeByLevel(tree);
        System.out.println(s);

    }
}
