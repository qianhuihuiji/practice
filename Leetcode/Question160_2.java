package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 */
public class Question160_2 {
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
        ListNode pA = headA;
        ListNode pB = headB;

        // 双指针法
        // pA 从 A 链表出发，遍历 A + B 链表
        // pB 从 B 链表出发，遍历 B + A 链表
        // 如果 A、B 相交的话，那么它们一定会相遇，因为它们的尾部相同， A +  B 的尾部自然也相同
        while (pA != pB) { // 遍历到末尾的时候，如果两个链表不想交，则最后一次循环后：pA = null,pB = null
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }

        return pA;
    }
}