package com.ssw.linkedlist.topic;

/**
 * 合并两个有序的单链表
 */
public class MergerTwoSortedLinkedList {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public Node merge(Node head1, Node head2) {

        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2; //cur1指向头节点值较小的那个链表
        Node cur2 = cur1 == head1 ? head2 : head1; //cur2指向头节点值较大的链表
        Node pre = null;
        Node next = null;

        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;//保留下一个节点地址
                pre.next = cur2;//链接到cur1所在链表
                cur2.next = cur1;//cur2的指针设置为cur1  [pre.next = cur2;cur2.next = cur1]这两部cur2节点就插入到了链表1中
                pre = cur2;//链表1上的pre指针右移动
                cur2 = next;//cur2指向链表2的下个节点
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(4);

        Node node2 = new Node(1);
        node2.next = new Node(3);
        node2.next.next = new Node(4);

        Node merge = new MergerTwoSortedLinkedList().merge(node1, node2);

        printLinkedList(merge);
    }
}
