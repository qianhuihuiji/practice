package Leetcode;

import java.util.*;

/**
 * [133] 克隆图
 */
public class Question132 {
    static Map<GraphNode, GraphNode> lookup = new HashMap<>();
    public static void main(String[] args) {
        /*
            输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
            输出：[[2,4],[1,3],[2,4],[1,3]]
         */
        GraphNode GraphNode1 = new GraphNode(1);
        GraphNode GraphNode2 = new GraphNode(2);
        GraphNode GraphNode3 = new GraphNode(3);
        GraphNode GraphNode4 = new GraphNode(4);
        GraphNode1.neighbors = Arrays.asList(new GraphNode[]{GraphNode2, GraphNode4});
        GraphNode2.neighbors = Arrays.asList(new GraphNode[]{GraphNode1, GraphNode3});
        GraphNode3.neighbors = Arrays.asList(new GraphNode[]{GraphNode2, GraphNode4});
        GraphNode4.neighbors = Arrays.asList(new GraphNode[]{GraphNode1, GraphNode3});


        GraphNode ans = cloneGraph(GraphNode1);

        System.out.println("当前节点值是:" + ans.val);
        ans.neighbors.forEach(node -> System.out.println(node.val));
    }

    // 深度优先搜索
    private static GraphNode cloneGraph(GraphNode node) {
        if (node == null) return node;

        // 如果已经遍历过
        if (lookup.containsKey(node)) return lookup.get(node);

        // 克隆节点
        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<>());
        // 存入 map
        lookup.put(node, cloneNode);

        // 设置邻居
        for (GraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}