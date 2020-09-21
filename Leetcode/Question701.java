package Leetcode;


/**
 * [98] 验证二叉搜索树
 */
public class Question701 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode ans = insertIntoBST(node1, 5);

        TreeNode.preOrder(ans);
    }

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode head = root;
        TreeNode insertNode = new TreeNode(val);

        while (head != null) {
            if (head.val > val) {
                if (head.left == null) {
                    head.left = insertNode;
                    head = null;
                } else {
                    head = head.left;
                }
            } else {
                if (head.right == null) {
                    head.right = insertNode;
                    head = null;
                } else {
                    head = head.right;
                }
            }
        }

        return root;
    }
}