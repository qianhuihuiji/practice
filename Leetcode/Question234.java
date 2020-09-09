package Leetcode;

import java.util.Stack;

/**
 * 回文链表
 */
public class Question234 {
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
        Stack<ListNode> lookup = new Stack<>();

        ListNode node = head;

        // 先遍历链表，同时入栈
        while (node != null) {
            lookup.add(node);

            node = node.next;
        }

        // 遍历链表，同时出栈，进行比较
        while (head != null) {
            ListNode nodeInStack = lookup.pop();

            if (nodeInStack.val != head.val) {
                return false;
            }

            head = head.next;
        }

        return true;
    }
}