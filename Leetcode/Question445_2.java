package Leetcode;

import java.util.Stack;

/**
 * [2] 两数相加
 */
public class Question445_2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
//        node5.next = node6;
//        node6.next = node7;

        ListNode ans = addTwoNumbers(node1, node5);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode head1 = l1;
        ListNode head2 = l2;

        while (head1 != null) {
            stack1.add(head1);

            head1 = head1.next;
        }

        while (head2 != null) {
            stack2.add(head2);

            head2 = head2.next;
        }

        int size1 = stack1.size();
        int size2 = stack2.size();

        Stack<ListNode> baseStack = size1 > size2 ? stack1 : stack2;
        Stack<ListNode> otherStack = size1 > size2 ? stack2 : stack1;

        // 是否需要补位
        boolean supply = false;
        while (! baseStack.isEmpty()) {
            int val = 0;
            if (! otherStack.isEmpty()) {
                ListNode tmp = otherStack.pop();
                val += tmp.val;
            }

            if (supply) {
                val++;
                supply = false;
            }

            ListNode node = baseStack.pop();
            int nodeVal = node.val + val;

            if (nodeVal >= 10) {
                nodeVal -= 10;
                supply = true;
            }

            node.val = nodeVal;
        }

        ListNode result = size1 > size2 ? l1 : l2;

        if (supply) {
            ListNode tmp = new ListNode(1);
            tmp.next = result;

            return tmp;
        }

        return result;
    }
}