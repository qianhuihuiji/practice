package Leetcode;

/**
 * [121] 买卖股票的最佳时机
 */
public class Question121 {
    public static void main(String[] args) {
//        int[] test = new int[] {7,1,5,3,6,4};
        int[] test = new int[] {7,6,4,3,1};
        int ans = maxProfit(test);
        System.out.println(ans);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int x : prices) {
            if (x < minPrice) {
                minPrice = x;
            } else if (x - minPrice > maxProfit) {
                maxProfit = x - minPrice;
            }
        }

        return maxProfit;
    }
}