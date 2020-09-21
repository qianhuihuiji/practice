package Leetcode;


/**
 * [98] 验证二叉搜索树
 */
public class Question98 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;

        boolean ans = isValidBST(node1);

        System.out.println(ans);
    }

    private static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        int val = root.val;

        if (lower != null && val <= lower) return false;

        if (upper != null && val >= upper) return false;

        if (! helper(root.left, lower, val)) return false;

        if (! helper(root.right, val, upper)) return false;

        return true;
    }
}