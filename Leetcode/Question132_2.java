package Leetcode;

import java.util.*;

/**
 * [133] 克隆图
 */
public class Question132_2 {
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

    // 广度优先搜索
    private static GraphNode cloneGraph(GraphNode node) {
        if (node == null) return node;

        Map<GraphNode, GraphNode> lookup = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        // 处理第一个顶点
        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<>());
        lookup.put(node, cloneNode);
        queue.add(node);

        while (! queue.isEmpty()) {
            GraphNode n = queue.poll();

            // 遍历原邻居节点，同时克隆
            for (GraphNode neighbor : n.neighbors) {
                // 如果这个节点没有访问过
                if (! lookup.containsKey(neighbor)) {
                    // 克隆并存取到哈希表中
                    lookup.put(neighbor, new GraphNode(neighbor.val, new ArrayList<>()));
                    // 放入队列
                    queue.add(neighbor);
                }

                // 设置克隆节点的邻居
                lookup.get(neighbor).neighbors.add(lookup.get(node));
            }
        }

        return cloneNode;
    }
}