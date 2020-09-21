package Leetcode;

import java.util.*;

/**
 * [102] 二叉树的层序遍历
 */
public class Question102 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node8;
        node2.right = node9;
        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> ans = levelOrder(node1);

        ans.forEach(list -> list.forEach(System.out::println));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}