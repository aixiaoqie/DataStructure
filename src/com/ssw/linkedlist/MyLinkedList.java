package com.ssw.linkedlist;

/**
 * 单链表
 */
public class MyLinkedList {

    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 反转单链表
     */
    public Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 判断两个无环链表是否相交，若相交返回交点
     */
    public Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node n1 = head1;
        Node n2 = head2;
        int n = 0;
        while (n1.next != null) {
            n++;
            n1 = n1.next;
        }
        while (n2.next != null) {
            n--;
            n2 = n2.next;
        }
        if (n1 != n2) {
            return null; //链表最后一个节点若不相等则两个无环链表不相交
        }
        n1 = n > 0 ? head1 : head2; //n1指向 head1 head2 两个链表较长的那个
        n2 = n1 == head1 ? head2 : head1; // n2 指向 head1 head2 两个链表较短的那个
        n = Math.abs(n);
        while (n > 0) {
            n--;
            n1 = n1.next;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    /**
     * 判断链表是否有环，有环返回第一个进入环的节点
     */
    public Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;

    }

    /**
     * 判断两个有环链表是否相交。相交返回第一个相交节点
     * 1).两个链表入环节点相同
     * 2).两个链表入环节点不同
     */
    public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node n1 = null, n2 = null;
        if (loop1 == loop2) {  //两个链表入环节点相同
            int n = 0;
            n1 = head1;
            n2 = head2;
            while (n1 != loop1) {
                n++;
                n1 = n1.next;
            }
            while (n2 != loop2) {
                n--;
                n2 = n2.next;
            }
            n1 = n > 0 ? head1 : head2;     // n1指向 head1 head2 两个链表较长的那个
            n2 = n1 == head1 ? head2 : head1;// n2 指向 head1 head2 两个链表较短的那个
            n = Math.abs(n);
            while (n > 0) {
                n--;
                n1 = n1.next;
            }
            while (n1 != n2) {
                n1 = n1.next;
                n2 = n2.next;
            }
            return n1;
        } else {  //两个链表入环节点不同
            n1 = loop1.next;
            while (n1 != loop1) {  //链表环内走一圈若没有遇上loop2说明两个链表不在一个环上
                if (n1 == loop2) {
                    return loop1;
                }
                n1 = n1.next;
            }
            return null;
        }
    }
}
