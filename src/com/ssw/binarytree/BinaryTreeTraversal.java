package src.com.ssw.binarytree;

import java.util.Stack;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraversal {

    class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //递归实现先序遍历
    public void preRootTraversal(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value + "");
        preRootTraversal(head.left);
        preRootTraversal(head.right);
    }

    //递归实现中序遍历
    public void midRootTraversal(Node head) {
        if (head == null) {
            return;
        }
        midRootTraversal(head.left);
        System.out.println(head.value + "");
        midRootTraversal(head.right);
    }

    //递归实现后序遍历
    public void afterRootTraversal(Node head) {
        if (head == null) {
            return;
        }
        afterRootTraversal(head.left);
        afterRootTraversal(head.right);
        System.out.println(head.value + "");
    }


    //非递归实现先序遍历
    public void preRootTraversalNonRecursive(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.empty()) {
                head = stack.pop();
                System.out.println(head.value + "");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }
}
