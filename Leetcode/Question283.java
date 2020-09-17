package Leetcode;

/**
 * [283] 移动零
 */
public class Question283 {
    public static void main(String[] args) {
        /*
            输入: [0,1,0,3,12]
            输出: [1,3,12,0,0]
         */
        int[] nums = new int[] {0,1,0,3,12,0};
        moveZeroes(nums);
        for (int val : nums) {
            System.out.println(val);
        }
    }

    private static void moveZeroes(int[] nums) {
        int positiveCount = 0;
        int positiveIndex = 0;

        while (positiveIndex < nums.length) {
            while (positiveIndex < nums.length && nums[positiveIndex] == 0) positiveIndex++;

            if (positiveIndex < nums.length) {
                nums[positiveCount++] = nums[positiveIndex++];
            }
        }

        // 后面的数字置为 0
        while (positiveCount < nums.length) {
            nums[positiveCount++] = 0;
        }
    }
}