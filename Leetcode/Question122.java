package Leetcode;

/**
 * [122] 买卖股票的最佳时机II
 */
public class Question122 {
    public static void main(String[] args) {
//        int[] test = new int[] {1,2,0,1};
        int[] test = new int[] {7,1,5,3,4,6};
        int ans = maxProfit(test);
        System.out.println(ans);
    }

    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0;i < prices.length; i++) {
            int x = prices[i];
            if (x - minPrice <= maxProfit) { // 一旦最大利润开始下降，马上卖出
                totalProfit += maxProfit;

                // 卖出的时候，视为从本次重新开始选股，因此历史最低价是 x 本身
                maxProfit = 0;
                minPrice = x;
                continue;
            } else if (x < minPrice) {
                minPrice = x;
            } else if (x - minPrice > maxProfit) {
                maxProfit = x - minPrice;

            }

            // 如果一直涨到最后一天，那么会在最后一天卖出
            if (i == prices.length - 1) {
                totalProfit += maxProfit;
            }
        }

        return totalProfit;
    }
}