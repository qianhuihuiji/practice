package Leetcode;

public class Question24 {
    public static void main(String[] args) {
        ListNode24 node1 = new ListNode24(1);
        ListNode24 node2 = new ListNode24(2);
        ListNode24 node3 = new ListNode24(3);
        ListNode24 node4 = new ListNode24(4);
        ListNode24 node5 = new ListNode24(5);
        ListNode24 node6 = new ListNode24(6);
        ListNode24 node7 = new ListNode24(7);
        ListNode24 node8 = new ListNode24(8);
        ListNode24 node9 = new ListNode24(9);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        ListNode24 node = swapPairs(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode24 swapPairs(ListNode24 head) {
        if (head.next == null) return head;

        // 利用哨兵节点简化代码
        ListNode24 sentinel = new ListNode24(-1);
        sentinel.next = head;

        ListNode24 preNode = sentinel;

        while ((head != null) && (head.next != null)) {
            // 要交换的两个节点
            ListNode24 firstNode = head;
            ListNode24 secondNode = head.next;

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

class ListNode24 {
    int val;
    ListNode24 next;
    ListNode24(int val) {
       this.val = val;
   }
}