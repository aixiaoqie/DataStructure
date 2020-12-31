package com.ssw.binarytree;

/**
 * Morris遍历方法 实现二叉树的先序 中序 后序遍历
 */
public class BinaryTreeTraversalByMorris {

    /**
     * morris 中序遍历
     * 具体过程：
     * 1. 假设当前子树的头节点为 h，让 h的左子树中最右节点的right指针指向 h;
     * 然后 h的左子树继续步骤1的过程, 直到遇到某一个节点没有左子树为止,记为node，然后进入步骤 2
     * <p>
     * 2. 从node开始通过每个节点的right指针进行移动，并依次打印，假设移动到的节点为cur。
     * 对于每一个cur节点都判断其左子树中的最右节点是否指向cur:
     * ①若指向，让cur节点的左子树最右面节点指针指向空，也就是把步骤1调整后的再调整回来。然后打印cur节点，经过cur.right移动到下一个节点
     * ②若不指向，以cur节点为头的子树重回步骤 1 执行。
     * <p>
     * 3.步骤2最终移动到null，整个过程结束
     * <p>
     * <p>
     * 以上步骤得出结论，打印cur节点时一定是在步骤2开始移动的过程中，
     * 要么是某个节点移动到右子树的过程，此时左子树以及根节点已经打印结束，然后开始处理右子树的过程；
     * 要么是某个节点移动到某个上层节点，此时必是这个上层节点的左子树整体打印完毕，然后开始处理根节点和右子树的过程。
     */
    public void morrisMidTraversal(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right; //将cur节点左子树最右面节点指向当前cur节点
                }
                if (cur2.right == null) {  //此时是在进行步骤1，步骤2② ; 让h的左子树中最右节点的right指针指向h
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;//进行步骤1 （直到遇到某一个节点没有左子树为止，此时不跳出循环开始打印node节点）
                } else {
                    cur2.right = null;//步骤2①
                }
            }
            System.out.println(cur1.value + "");
            cur1 = cur1.right;
        }
        System.out.println();
    }

    /**
     * morris 先序遍历，是中序遍历的简单调整，即将打印时机放在步骤1即可，（调整当前节点的左子树最右面节点指向当前节点）
     */
    public void morrisPreTraversal(Node head) {
        if (head == null) {
            return;
        }
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
                    System.out.println(cur1.value + "");//先序遍历此时打印根节点
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            } else {
                System.out.println(cur1.value + "");//说明此时到了叶子节点
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }


    /**
     * morris 后序遍历
     * <p>
     * 中序遍历的改写：
     * 依次逆序打印所有节点的左子树的右边界，打印时机放在步骤2①触发，也就是调整回去的过程发生的时候。
     *
     * @param head
     */
    public void morrisLaterTraversal(Node head) {
        if (head == null) {
            return;
        }
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
                    cur2.right = null;//步骤2①； cur2.right为当前节点cur的左子树最右面节点
                    printEdge(cur1.left); //逆序打印当前节点左子树的右边界
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head); //单独逆序打印整棵的右边界
        System.out.println();
    }


    public void printEdge(Node head) {
        Node tail = reversEdge(head);//反转二叉树的右面边界
        Node cur = tail;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.right;
        }
        reversEdge(tail);//调整回来
    }

    /**
     * 反转二叉树的边界,此题用来反转二叉树的右边界
     */
    public Node reversEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;

    }
}


























