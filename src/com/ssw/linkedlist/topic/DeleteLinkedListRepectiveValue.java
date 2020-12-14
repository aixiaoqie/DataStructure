package src.com.ssw.linkedlist.topic;

import java.util.HashSet;

/**
 * 删除 一个无序单链表中值出现重复的节点
 * <p>
 * 例如 1->2->3->3->4->2->1->1->null,删除重复节点后为1->2->3->4->null
 */
public class DeleteLinkedListRepectiveValue {

    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    /**
     * 1. 利用hash表 时间复杂度 O(N) 额外空间复杂度为 O(N)
     */
    public void deleteNode1(Node head) {
        if (head == null) {
            return;
        }
        Node pre = head;
        Node cur = head.next;
        HashSet<Integer> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next; //set中存在当前节点的值，删除当前节点
            } else {
                set.add(cur.value);
                pre = cur; // 更新最近没有删除的节点
            }
            cur = cur.next;
        }
    }

    /**
     * 类似选择排序的过程，依次从1选择后面出现的节点删除
     * 额外空间复杂度 O(1)
     */

    public void deleteNode2(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            pre = cur;  // 更新最近没有删除的节点
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                   pre = next;   // 更新最近没有删除的节点
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
