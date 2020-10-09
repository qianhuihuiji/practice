package Leetcode;

/**
 * [148] 排序链表
 */
public class Question148_2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode ans = sortList(node1);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode sortList(ListNode head) {
        ListNode h, h1, h2, pre, res;
        h = head;
        // 记录长度
        int length = 0;
        // 最小合并单元
        int minMerge = 1;
        while (h != null) {
            h = h.next;
            length++;
        }
        // 哨兵节点
        res = new ListNode(-1);
        res.next = head;

        while (minMerge < length) {
            // 每一轮合并，都是从头开始的，所以取出头结点
            pre = res;
            h = res.next;

            while (h != null) {
                // h1 作为合并的前半部分，h2 作为合并的后半部分
                int i = minMerge;
                h1 = h;
                // 从 h 节点开始，找 i 个节点出来，作为合并的前半部分
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                // 如果前半部分的数量已经比最小合并单元小，那么就跳出，直接进行下一轮合并
                if (i > 0) break;

                // 此时 h 已经移动到后半部分的头结点的位置
                // 从 h 节点开始，找 i 个节点出来，作为合并的后半部分
                i = minMerge;
                h2 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }

                // c1 是前半部分的长度，c2是后半部分的长度
                // i 有可能为 0，也有可能不是，此时后半部分是整个链表的尾部，且长度小于最小合并单元
                int c1 = minMerge, c2 = minMerge - i;

                // 合并两个链表的逻辑
                // 由于两个部分并未断开，因此需要 c1、c2 作为辅助
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                // 某个部分没有合并完
                pre.next = c1 == 0 ? h2 : h1;

                // 移动 pre 到本次合并的后半部分的尾部
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }

                // 此时 h 已经移到本轮合并中，下一组合并的前半部分的头结点的位置
                pre.next = h;
            }

            // 完成一轮合并后，最小合并单元变为之前的 2 倍
            minMerge *= 2;
        }

        return res.next;
    }
}