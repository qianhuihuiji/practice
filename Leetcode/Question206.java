package Leetcode;

public class Question206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = reverseList(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            // 利用 tmp 保存下一个节点的引用
            ListNode tmp = node.next;

            // 反转指针
            node.next = pre;

            // 向后移动
            pre = node;
            node = tmp;
        }

        return pre;
    }

}