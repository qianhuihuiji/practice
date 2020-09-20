package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [110] 平衡二叉树
 */
public class Question110 {
    private static Map<TreeNode, Integer> lookup = new HashMap<>();
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        boolean ans = isBalanced(node1);

        System.out.println(ans);
    }

    private static boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}