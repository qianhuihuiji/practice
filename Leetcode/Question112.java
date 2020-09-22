package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [112] 路径总和
 */
public class Question112 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        node1.left = node2;
//        node1.right = node3;

        boolean ans = hasPathSum(node1, 1);

        System.out.println(ans);
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null ) return false;

        // 如果已经是叶子节点
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}