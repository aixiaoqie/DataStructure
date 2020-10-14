package com.ssw.linkedlist;

/**
 * 单链表
 */
public class MyLinkedList {

    class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 反转单链表
     */
    public Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        Node cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
