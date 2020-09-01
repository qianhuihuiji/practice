package Leetcode;

/**
 * [2] 两数相加
 */
public class Question2 {
    public static void main(String[] args) {
        ListNode2 node1 = new ListNode2(2);
        ListNode2 node2 = new ListNode2(4);
        ListNode2 node3 = new ListNode2(3);
        node1.next = node2;
        node2.next = node3;

        ListNode2 node4 = new ListNode2(5);
        ListNode2 node5 = new ListNode2(6);
        ListNode2 node6 = new ListNode2(7);
        node4.next = node5;
        node5.next = node6;

        ListNode2 ans = addTwoNumbers(node1, node4);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        if (l1 == null && l2 == null) return null;

        ListNode2 ans = new ListNode2(-1);
        ListNode2 head = ans;

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
                ans.next = new ListNode2(-1);
                ans = ans.next;
            }
        }

        return head;
    }

}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int val) {
       this.val = val;
   }
}