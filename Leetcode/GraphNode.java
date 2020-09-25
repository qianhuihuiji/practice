package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a Node.
 *
 * @author nofirst
 * @date 2020-09-25 14:53
 */
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
