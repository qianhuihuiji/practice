package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 */
public class Question234_2 {
    public static void main(String[] args) {
        // 1->2->2->1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        boolean ans = isPalindrome(node1);
        System.out.println(ans);
    }

    private static boolean isPalindrome(ListNode head) {
        // 利用数组和头尾双指针来解决
        List<Integer> vals = new ArrayList<>();

        ListNode dog = head;
        while (dog != null) {
            vals.add(dog.val);

            dog = dog.next;
        }

        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (! vals.get(front).equals(vals.get(back))) return false;

            front++;
            back--;
        }

        return true;
    }
}