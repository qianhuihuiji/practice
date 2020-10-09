package Leetcode;

/**
 * 剑指 Offer 28. 对称的二叉树
 */
public class SwordToOffer28 {
    public static void main(String[] args) {
        /*
            输入：root = [1,2,2,3,4,4,3]
            输出：true
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        boolean ans = isSymmetric(node1);

        System.out.println(ans);
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) return false;

        return false;
    }
}