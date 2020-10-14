package com.ssw.linkedlist;

/**
 * 双向链表
 */
public class MyDoubleLinkedList {
    class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public  DoubleNode(int value){
            this.value = value;
        }


        /**
         * 反转双向链表
         */
        public DoubleNode reverseDoubleLinkedList(DoubleNode head){
            DoubleNode pre = null;
            DoubleNode next = null;
            DoubleNode cur = head;
            while(cur != null){
                next = cur.next;
                cur.next = pre;
                cur.last = next;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
