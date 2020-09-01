package Leetcode;

public class Question24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        ListNode node = swapPairs(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        if (head.next == null) return head;

        // 利用哨兵节点简化代码
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode preNode = sentinel;

        while ((head != null) && (head.next != null)) {
            // 要交换的两个节点
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 交换
            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 移动
            preNode = firstNode;
            head = firstNode.next;
        }

        return sentinel.next;
    }

}