package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Question86 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node33 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node44 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node33;
        node33.next = node4;
        node4.next = node44;

        ListNode ans = partition(node1, 3);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        Queue<ListNode> smallQueue = new ArrayDeque<>();
        Queue<ListNode> largeQueue = new ArrayDeque<>();

        while (head != null) {
            if (head.val < x) {
                smallQueue.add(head);
            } else {
                largeQueue.add(head);
            }

            head = head.next;
        }

        // 设置返回的 node
        ListNode newHead;
        if (! smallQueue.isEmpty()) {
            newHead = smallQueue.poll();
        } else {
            newHead = largeQueue.poll();
        }

        ListNode pre = newHead;
        while (! smallQueue.isEmpty()) {
            ListNode tmp = smallQueue.poll();
            pre.next = tmp;
            pre = tmp;
        }

        while (! largeQueue.isEmpty()) {
            ListNode tmp = largeQueue.poll();
            pre.next = tmp;
            pre = tmp;
        }

        // 把最后一个节点指向 null
        pre.next = null;

        return newHead;
    }
}