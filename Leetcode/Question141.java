package Leetcode;

/**
 * [141] 环形链表
 */
public class Question141 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;

        boolean ans = hasCycle(node1);
        System.out.println(ans);
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast.next == slow || fast.next.next == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

}