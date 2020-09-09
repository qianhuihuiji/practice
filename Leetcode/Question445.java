package Leetcode;

/**
 * [2] 两数相加
 */
public class Question445 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node5.next = node6;
        node6.next = node7;

        ListNode ans = addTwoNumbers(node1, node5);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        return reverseList(add(l1, l2));
    }

    private static ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            // 利用 tmp 保存下一个节点的引用
            ListNode tmp = node.next;

            // 反转指针
            node.next = pre;

            // 向后移动
            pre = node;
            node = tmp;
        }

        return pre;
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode ans = new ListNode(-1);
        ListNode head = ans;

        // 是否需要补位
        boolean supply = false;

        while (l1 != null || l2 != null || supply) {
            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val = l1.val;
                l1 = l1.next;
            } else if (l2 != null){
                val = l2.val;
                l2 = l2.next;
            }

            // 需要补位的话，进行补位，并将补位标志重置
            if (supply) {
                val++;
                supply = false;
            }

            // 判断本次是否需要补位
            if (val >= 10) {
                supply = true;
                val -= 10;
            }

            ans.val = val;

            if (l1 != null || l2 != null || supply) {
                ans.next = new ListNode(-1);
                ans = ans.next;
            }
        }

        return head;
    }
}