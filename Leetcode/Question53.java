package Leetcode;

/**
 * [53] 最大子序和
 */
public class Question53 {
    public static void main(String[] args) {
        int[] test = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int ans = maxSubArray(test);
        System.out.println(ans);
    }

    private static int maxSubArray(int[] nums) {
        // 鬼鬼，这动态规划，秒啊
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}