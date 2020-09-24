package Leetcode;

/**
 * [143] 重排链表
 */
public class Question143_2 {
    public static void main(String[] args) {
        /*
            给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        reorderList(node1);

        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    private static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        // 快慢指针，找到中间节点
        ListNode slow = head, fast = head, oldHead = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next;
            }
        }
        // 反转后半部分链表
        ListNode pre = null;
        ListNode cur = slow.next;

        // 断开中间部分
        slow.next = null;

        while (cur != null) {
            ListNode tmp = cur.next;

            // 反转
            cur.next = pre;

            // 前进
            pre = cur;
            cur = tmp;
        }

        while (fast != null) {
            ListNode tmp = oldHead.next;
            ListNode fastNext = fast.next;

            oldHead.next = fast;
            oldHead.next.next = tmp;

            oldHead = tmp;
            fast = fastNext;
        }
    }
}