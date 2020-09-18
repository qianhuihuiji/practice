package Leetcode;

/**
 * [495] 提莫攻击
 */
public class Question495 {
    public static void main(String[] args) {
        /*
            输入: [1,2], 2
            输出: 3
         */
        int[] nums = new int[] {1,4};
        int ans = findPoisonedDuration(nums, 2);
        System.out.println(ans);
    }

    private static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int seconds = duration;

        for (int i = 1;i < timeSeries.length;i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];

            if (diff >= duration) seconds += duration;
            else seconds = seconds + diff;
        }

        return seconds;
    }
}