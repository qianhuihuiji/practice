package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * [148] 排序链表
 */
public class Question148 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode ans = sortList(node1);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode sortList(ListNode head) {
        // 终止条件：head 为 null，或者 head 无后驱节点
        if (head == null || head.next == null)
            return head;

        // 快慢指针，找中间节点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 临时保存后半部分的首节点
        ListNode tmp = slow.next;

        // 断开前后两部分
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 合并
        // 利用哨兵节点
        ListNode newHead = new ListNode(-1);
        ListNode res = newHead;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                newHead.next = left;
                left = left.next;
            } else {
                newHead.next = right;
                right = right.next;
            }

            // 移动
            newHead = newHead.next;
        }

        // 如果还有某部分没合并完
        newHead.next = left == null ? right : left;

        return res.next;
    }
}