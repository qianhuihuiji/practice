package Leetcode;

public class Question83 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
//        ListNode node33 = new ListNode(2);
//        ListNode node4 = new ListNode(3);
//        ListNode node44 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node33;
//        node33.next = node4;
//        node4.next = node44;
//        node44.next = node5;

        ListNode ans = deleteDuplicates(node1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head;
        ListNode pre = head;

        while (head != null) {
            while (head != null && pre.val == head.val) {
                head = head.next;
            }

            pre.next = head;
            pre = head;
        }

        return newHead;
    }
}