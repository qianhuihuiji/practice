package Leetcode;

public class Question21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(3);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(2);
        ListNode l222 = new ListNode(3);
        l2.next = l22;
        l22.next = l222;

        ListNode ans = mergeTwoLists(l1, l2);
        while (ans.next != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 不能直接用 preHead 去遍历
        // 在这里 preHead 是一个灯塔，pre 是一个哨兵
        // 一开始两者都指向同一个 ListNode，但是哨兵在后续的过程中会改成自己的身份，将后续的 ListNode 都连接起来
        // 因此只需要返回 preHead.next 即可
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