package Leetcode;

import java.util.*;

/**
 * [236] 二叉树的最近公共祖先
 */
public class Question236 {
    static Map<Integer, TreeNode> parentLookup = new HashMap<>();
    static Set<TreeNode> visited = new HashSet<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.left = node8;
//        node5.right = node9;

        TreeNode ans = lowestCommonAncestor(node1, node1, node2);

        System.out.println(ans.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p);
            p = parentLookup.getOrDefault(p.val, null);
        }

        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }

            q = parentLookup.get(q.val);
        }

        return null;
    }

    private static void dfs(TreeNode root) {
        if (root.left != null) {
            parentLookup.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentLookup.put(root.right.val, root);
            dfs(root.right);
        }
    }
}