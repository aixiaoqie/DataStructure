package com.ssw.linkedlist;

/**
 * 单链表/双链表删除倒数第 k 个节点
 */
public class RemoveLastkthNode {
    class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 删除单链表倒数第 k 个节点
     */
    public Node removeLinkedListLastkthNode(Node head, int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            lastKth--;
            cur = cur.next;
        }
        //
        if(lastKth == 0){
            head = head.next;
        }
        if(lastKth < 0){
            cur = head;
            while(++lastKth !=0){
                cur = cur.next;
            }
            //链表长度为N,倒数第K个节点为N-k+1,将其前一个节点N-K与后一个节点相连,即删除当前节点
            cur.next = cur.next.next;
        }
        return head;
    }
}
