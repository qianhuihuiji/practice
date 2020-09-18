package Leetcode;

/**
 * [485] 最大连续1的个数
 */
public class Question485 {
    public static void main(String[] args) {
        /*
            输入: [1,1,0,1,1,1]
            输出: 3
         */
        int[] nums = new int[] {1,0,1,1,0,1};
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        int i = 0;
        while (i < nums.length) {
            int tmpMax = 0;
            while (i < nums.length && nums[i] == 1) {
                i++;
                tmpMax++;
            }

            max = Math.max(tmpMax, max);
            i++;
        }

        return max;
    }
}