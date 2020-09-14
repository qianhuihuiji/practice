package Leetcode;

/**
 * [92] 反转链表 II
 */
public class Question92 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode ans = reverseBetween(node1, 1, 5);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dog = head;
        ListNode pre = new ListNode(-1);
        int index = 1;
        while (index < m) {
            pre = dog;
            dog = dog.next;
            index++;
        }

        ListNode preNode = pre;
        ListNode firstNode = dog;

        while (index <= n) {
            ListNode tmp = dog.next;

            dog.next = pre;

            pre = dog;
            dog = tmp;
            index++;
        }

        ListNode tmp = dog;
        preNode.next = pre;
        firstNode.next = tmp;

        return  m == 1 ? preNode.next : head;
    }
}