package Leetcode;

/**
 * 回文链表
 */
public class Question234_3 {
    public static void main(String[] args) {
        // 1->2->2->1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        boolean ans = isPalindrome(node1);
        System.out.println(ans);
    }

    private static boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        // 使用快慢指针
        // 找到中间节点，同时反转前半部分链表，然后从中间节点向两边遍历
        // 节点个数分奇数和偶数两种情况
        ListNode slow = head;
        ListNode fast = head;
        ListNode middle = slow.next;
        while (fast.next != null) {
            // 这种情况说明是偶数个节点，且到了最后一步
            if (fast.next.next == null) {
                fast = fast.next;
            } else {
                // 反转前半部分链表
                ListNode tmp = slow.next;
                slow = slow.next;
                middle = slow.next;

                slow.next = tmp;
                fast = fast.next.next;
            }
        }

        return true;
    }
}