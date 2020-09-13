package Leetcode;

/**
 * [725] 分隔链表
 */
public class Question725 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;

        ListNode[] ans = splitListToParts(node1, 5);
        for (ListNode node : ans) {
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }

            System.out.println("end of a group");
        }
    }

    private static ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) return new ListNode[k];

        ListNode head = root;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        ListNode[] ans = new ListNode[k];

        // 每组的的元素个数
        int baseElements = size / k;
        // 需要额外补充元素的组的个数，每组会额外补充一个元素
        int suppliedGroups = size % k;

        int groupIndex = 0;

        while (groupIndex < k) {
            ans[groupIndex] = root;

            for (int i = 1;i < baseElements;i++) {
                if (root != null) root = root.next;
            }

            if (groupIndex < suppliedGroups) {
                if (baseElements != 0 &&  root != null) root = root.next;
            }

            if (root != null) {
                ListNode tmp = root.next;
                root.next = null;
                root = tmp;
            }

            groupIndex++;
        }


        return ans;
    }
}