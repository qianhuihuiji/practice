package Leetcode;

/**
 * [198] 打家劫舍
 */
public class Question198 {
    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,1};
        int answer = rob(test);
        System.out.println(answer);
    }

    private static int rob(int[] nums) {
        if (nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        int length = nums.length;
        int[] values = new int[length];
        values[0] = nums[0];
        values[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i=2;i<nums.length;i++) {
            values[i] = Math.max(values[i-1], values[i-2]+nums[i]);
        }

        return values[nums.length-1];
    }
}