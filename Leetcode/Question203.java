package Leetcode;

/**
 * 移除链表元素
 */
public class Question203 {
    public static void main(String[] args) {
        // 1->2->6->3->4->5->6
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode ans = removeElements(node1, 6);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        ListNode dog = preHead;
        while (head != null) {
            while (head != null && head.val == val) {
                head = head.next;
            }

            preHead.next = head;
            preHead = preHead.next;
            head = head == null ? null : head.next;
        }

        return dog.next;
    }
}