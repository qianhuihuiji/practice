package Leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * [142] 环形链表II
 */
public class Question142 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode ans = detectCycle(node1);
        System.out.println(ans.val);
    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        Set<ListNode> lookup = new HashSet<>();
        while (head.next != null) {
            if (lookup.contains(head)) {
                return head;
            } else {
                lookup.add(head);
            }

            head = head.next;
        }

        return null;
    }
}