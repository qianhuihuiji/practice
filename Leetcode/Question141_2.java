package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * [141] 环形链表
 */
public class Question141_2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        boolean ans = hasCycle(node1);
        System.out.println(ans);
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        Set<ListNode> lookup = new HashSet<>();
        while (head.next != null) {
            if (lookup.contains(head)) {
                return true;
            } else {
                lookup.add(head);
            }

            head = head.next;
        }

        return false;
    }

}