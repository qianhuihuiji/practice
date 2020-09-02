package Leetcode;

import java.util.Arrays;

public class Question23 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(5);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l222 = new ListNode(4);
        l2.next = l22;
        l22.next = l222;

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[] {l1, l2, l3};

        ListNode ans = mergeKLists(list);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        // 空数组直接返回 null
        if (lists.length == 0) return null;

        // 数组里只有一个元素
        if (lists.length == 1) {
            return lists[0];
        }

        if (lists.length == 2) {
            // 不能直接用 preHead 去遍历
            // 在这里 preHead 是一个灯塔，pre 是一个哨兵
            // 一开始两者都指向同一个 ListNode，但是哨兵在后续的过程中会改成自己的身份，将后续的 ListNode 都连接起来
            // 因此只需要返回 preHead.next 即可
            ListNode l1 = lists[0];
            ListNode l2 = lists[1];

            return merge(l1, l2);
        }

        ListNode l1 = lists[0];
        ListNode l2 = mergeKLists(Arrays.copyOfRange(lists, 1, lists.length));

        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (l1 != null && l2!= null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }

            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}