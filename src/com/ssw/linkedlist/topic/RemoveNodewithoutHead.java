package com.ssw.linkedlist.topic;

/**
 * 一个值为int类型的链表，不给链表head节点，如何删除一个指定的节点，
 * 时间复杂度为O(1)，并且分析可能出现的问题
 */
public class RemoveNodewithoutHead {

    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void removeNode(Node node) throws Exception {
        if (node == null) {
            return;
        }

        Node next = node.next;
        if (next == null) {
            throw new Exception("无法删除最后一个节点");
        }
        node.value = next.value;  //保留下一个节点的值到当前节点，并删除下个节点
        node.next = next.next;
    }

}
