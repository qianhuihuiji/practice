package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [138] 复制带随机指针的链表
 */
public class Question138 {
    public static void main(String[] args) {
        /*
            输入：head = [[3,null],[3,0],[3,null]]
            输出：[[3,null],[3,0],[3,null]]
         */
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        node1.next = node2;
        node1.random = null;

        node2.next = node3;
        node2.random = node1;

        Node ans = copyRandomList(node1);

        while (ans != null) {
            String randomVal = ans.random == null ? "null" : ans.random.val + "";
            System.out.println("val is: " + ans.val + " ,random val is: " + randomVal);
            ans = ans.next;
        }
    }

    private static Node copyRandomList(Node head) {
        if (head == null) return null;

        // 遍历原始链表，存map
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Map<Integer, Node> indexToNode = new HashMap<>();
        int index = 1;
        while (head != null) {
            nodeToIndex.put(head, index);
            indexToNode.put(index, head);

            index++;
            head = head.next;
        }

        // 将初始答案存入map
        Map<Integer, Node> ansIndexToNode = new HashMap<>();
        for (int j = 1;j < index;j++) {
            Node tmp = new Node(indexToNode.get(j).val);

            ansIndexToNode.put(j, tmp);
        }

        // 构建random和next联系
        for (int j = 1;j < index;j++) {

            if (indexToNode.get(j).random == null) {
                ansIndexToNode.get(j).random = null;
            } else {
                int randomIndex = nodeToIndex.get(indexToNode.get(j).random);

                ansIndexToNode.get(j).random = ansIndexToNode.get(randomIndex);
            }

            if (indexToNode.get(j).next != null) {
                int nextIndex = nodeToIndex.get(indexToNode.get(j).next);

                ansIndexToNode.get(j).next = ansIndexToNode.get(nextIndex);
            }

        }

        return ansIndexToNode.get(1);
    }
}