package Leetcode;

/**
 * Definition for a binary tree node.
 *
 * @author nofirst
 * @date 2020-09-20 14:53
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
}
