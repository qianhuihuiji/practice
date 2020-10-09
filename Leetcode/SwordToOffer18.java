package Leetcode;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class SwordToOffer18 {
    public static void main(String[] args) {
        /*
            输入：head = [4,5,1,9], val = 5
            输出：[4,1,9]
         */
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode ans = deleteNode(node1, 5);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode deleteNode(ListNode head, int val) {
        if (head == null || head.next == null) return null;

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode ans = head;
        if (head.val == val) {
            ans = head.next;
            head.next = null;

            return ans;
        }

        while (head.val != val) {
            pre = head;
            head = head.next;
        }

        // 如果要删除是尾结点
        pre.next = head.next;

        return ans;
    }
}