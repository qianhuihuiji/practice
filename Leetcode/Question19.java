package Leetcode;

/**
 * [2] 两数相加
 */
public class Question19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
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
        ListNode orgHead = head;

        // 先计数
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        // 如果要删除的就是第一个节点
        if (size == n) return ans.next;

        // 再跳到删除点的前驱节点
        int count = 0;
        while (count < (size - n - 1)) {
            orgHead = orgHead.next;
            count++;
        }

        // 最后删除
        orgHead.next = orgHead.next.next;

        return ans;
    }

}