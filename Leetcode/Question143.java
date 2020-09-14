package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * [143] 重排链表
 */
public class Question143 {
    public static void main(String[] args) {
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
        Queue<ListNode> queue = new ArrayDeque<>();
        Stack<ListNode> stack = new Stack<>();
        int size = 0;

        while (head != null) {
            queue.add(head);
            stack.add(head);

            head = head.next;
            size++;
        }

        ListNode end = new ListNode(-1);
        int count = 0;
        int middle = size % 2 == 0 ? (size / 2) : (size / 2 + 1);
        while (count < middle) {
            ListNode nodeInQueue = queue.poll();
            ListNode nodeInStack = stack.pop();
            end.next = nodeInQueue;
            end.next.next = nodeInStack;
            end = nodeInStack;

            count++;
        }

        end.next = null;
    }
}