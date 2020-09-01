package Leetcode;

import java.util.Stack;

/**
 * [2] 两数相加
 */
public class Question19_2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode ans = removeNthFromEnd(node1, 1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        for (int i = 0;i < n;i++) {
            stack.pop();
        }

        // 如果 stack 为空，说明删除的是第一个
        if (stack.isEmpty()) return ans.next;

        ListNode pre = stack.pop();
        pre.next = pre.next.next;

        return ans;
    }

}