package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 */
public class Question160 {
    public static void main(String[] args) {
        // 0->9->1->2->4
        //       3->2->4
        // should return 2

        // 第一条链表
        ListNode node0 = new ListNode(0);
        ListNode node9 = new ListNode(9);
        ListNode node1 = new ListNode(1);

        // 公共节点
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        // 第二条链表
        ListNode node3 = new ListNode(3);

        node0.next = node9;
        node9.next = node1;
        node1.next = node2;
        node2.next = node4;

        node3.next = node2;

        ListNode ans = getIntersectionNode(node0, node3);
        System.out.println(ans == null ? null : ans.val );
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> lookup = new HashSet<>();
        while (headA != null) {
            lookup.add(headA);

            headA = headA.next;
        }

        while (headB != null) {
            if (lookup.contains(headB)) return headB;

            headB = headB.next;
        }

        return null;
    }
}