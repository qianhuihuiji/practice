package Leetcode;

public class Solution {
    public static void main(String[] args) {
        // 假设背包可承受重量 5，物品个数 5，数组 items 存储物品重量：
        int[] items = {2,2,4,6,3}; // 物品重量
        int[] values = {3,4,8,9,6}; // 物品价值
        int maxValue = pack(items,values ,5, 10);

        System.out.println("最大价值:" + maxValue);
    }

    private static int pack(int[] items, int[] values, int total, int totalWeight) {
        // 状态数组，初始值要处理成 -1
        int[] states = new int[totalWeight+1];
        for (int j = 0; j < totalWeight+1; ++j) {
            states[j] = -1;
        }

        // 第一行的数据要特殊处理，之后的每一行的状态是根据上一行的状态动态推导出来的
        // 不放第 0 个
        states[0] = 0;
        // 放第 0 个，前提是能放进去
        if (items[0] <= totalWeight) {
            states[items[0]] = values[0];
        }

        // 依次处理之后的行
        for (int i = 1;i < total;i++) {
            // 不放入第 i 个物品，对状态数组没有影响，因此无需处理

            // 放入第 i 个物品
            // 前提是能放进去，因此循环条件是 totalWeight - items[i]，这样可以减少循环次数
            // 这里需要从大到小循环，如果从小到大循环的话，可能会影响上一次决策后的结果，增加判断次数
            for (int j = totalWeight - items[i]; j >= 0; j--) {
                // 后一层的状态必须是上一层状态可达时才能转移
                if (states[j] >= 0) {
                    int tmpValue = states[j] + values[i];
                    // states[i][j + items[i]] 是此个 item 放入前该位置的值，如果比 -1 大，说明之前已经达到相同状态
                    // 所以要保留两者之间较大的
                    if (tmpValue > states[j + items[i]]) {
                        states[j + items[i]] = tmpValue;
                    }
                }
            }
        }
        // 得到结果，只用在最后一层，找到最大的一个价值
        int maxvalue = -1;
        for (int i = totalWeight;i >= 0;i--) {
            if (states[i] >= maxvalue) maxvalue = states[i];
        }
        return maxvalue;
    }
}