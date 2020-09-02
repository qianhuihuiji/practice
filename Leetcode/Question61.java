package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question61 {
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

        ListNode ans = rotateRight(node1, 2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        Deque<ListNode> deque = new ArrayDeque<>();
        int size = 0;
        ListNode originalHead = head;
        while (head != null) {
            // 入列
            deque.addLast(head);
            // 计数
            size++;

            head = head.next;
        }

        int moveStep = k % size;

        // 等于 0 说明不需要移动，那么直接返回初始状态即可
        if (moveStep == 0) return originalHead;

        while (moveStep > 0) {
            // 取出队列末尾的 node，插入到队列头部
            ListNode tmp = deque.pollLast();
            deque.addFirst(tmp);
            moveStep--;
        }

        ListNode nowHead = deque.getFirst();

        while (! deque.isEmpty()) {
            ListNode tmp = deque.pollFirst();
            if (deque.isEmpty()) {
                tmp.next = null;
            } else {
                ListNode tmpNext = deque.getFirst();
                tmp.next = tmpNext;
            }
        }

        return nowHead;
    }
}