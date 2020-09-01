package Leetcode;

/**
 * [141] 环形链表
 */
public class Question141 {
    public static void main(String[] args) {
        ListNode141 node1 = new ListNode141(3);
        ListNode141 node2 = new ListNode141(2);
        ListNode141 node3 = new ListNode141(0);
//        ListNode141 node4 = new ListNode141(-4);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;

        boolean ans = hasCycle(node1);
        System.out.println(ans);
    }

    private static boolean hasCycle(ListNode141 head) {
        if (head == null || head.next == null) return false;

        ListNode141 slow = head;
        ListNode141 fast = head.next;

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

class ListNode141 {
    int val;
    ListNode141 next;
    ListNode141(int val) {
       this.val = val;
       this.next = null;
   }
}