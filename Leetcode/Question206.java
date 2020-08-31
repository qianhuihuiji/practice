package Leetcode;

public class Question206 {
    public static void main(String[] args) {
        ListNode206 node1 = new ListNode206(1);
        ListNode206 node2 = new ListNode206(2);
        ListNode206 node3 = new ListNode206(3);
        ListNode206 node4 = new ListNode206(4);
        ListNode206 node5 = new ListNode206(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode206 node = reverseList(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode206 reverseList(ListNode206 head) {
        ListNode206 node = head;
        ListNode206 pre = null;
        while (node != null) {
            // 利用 tmp 保存下一个节点的引用
            ListNode206 tmp = node.next;

            // 反转指针
            node.next = pre;

            // 向后移动
            pre = node;
            node = tmp;
        }

        return pre;
    }

}

 class ListNode206 {
     int val;
     ListNode206 next;
     ListNode206(int val) {
        this.val = val;
    }
}