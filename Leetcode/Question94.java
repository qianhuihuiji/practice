package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [94] 二叉树的中序遍历
 */
public class Question94 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;

        List<Integer> ans = inorderTraversal(node1);

        ans.forEach(val -> System.out.println(val));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);

        return ans;
    }

    private static void inOrder(TreeNode root, List<Integer> queue) {
        if (root == null) return;

        inOrder(root.left, queue);
        queue.add(root.val);
        inOrder(root.right, queue);
    }
}