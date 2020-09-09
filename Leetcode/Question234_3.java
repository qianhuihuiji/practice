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
        if (head == null) return true;

        // 使用快慢指针
        // 找到中间节点，同时反转后半部分链表，然后从头尾两侧向中间遍历
        // 节点个数分奇数和偶数两种情况
        ListNode endOfFirstPart = endOfFirstPart(head);
        ListNode startOfSecondPartReversed = reverse(endOfFirstPart.next);

        ListNode p1 = head;
        ListNode p2 = startOfSecondPartReversed;

        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;

            p1 = p1.next;
            p2 = p2.next;
        }

        // 恢复原来链表的顺序
        endOfFirstPart.next = reverse(startOfSecondPartReversed);

        return result;
    }

    /**
     * 反转链表
     *
     * @param node
     * @return
     */
    private static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode tmp = cur.next;

            // 反转
            cur.next = pre;

            // 前进
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    /**
     * 使用快慢指针找到中间节点，同是也是第一个区域的最后一个节点
     *
     * @param head
     * @return
     */
    private static ListNode endOfFirstPart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null  && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
        }

        return slow;
    }
}