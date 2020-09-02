package Leetcode;

import java.util.Stack;

public class Question82 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node33 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node33;
        node33.next = node4;
//        node4.next = node44;
//        node44.next = node5;

        ListNode ans = deleteDuplicates(node1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        // 依次入栈
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        while (head != null) {
            // 设置 newHead
            if (stack.isEmpty()) {
                newHead = head;
                stack.push(head);
                head = head.next;
            } else {
                ListNode pre = stack.peek();
                if (pre.val != head.val) {
                    stack.push(head);

                    head = head.next;
                } else {
                    while (head != null && pre.val == head.val) {
                        head = head.next;
                    }
                    // 因为 pre 是重复值，所以需要出栈
                    stack.pop();

                    if (stack.isEmpty()) {
                        newHead = head;
                        stack.push(head);

                        if (head != null) {
                            head = head.next;
                        }
                    } else {
                        ListNode tmp = stack.peek();
                        tmp.next = head;
                    }
                }
            }
        }

        return newHead;
    }
}