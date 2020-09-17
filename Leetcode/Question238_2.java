package Leetcode;

/**
 * [238] 除自身以外数组的乘积
 */
public class Question238_2 {
    public static void main(String[] args) {
        /*
            输入: [1,2,3,4]
            输出: [24,12,8,6]
            2*3*4,1*3*4,1*2*4,1*2*3
         */
        int[] test = new int[] {1,2,3,4};
        int[]  ans = productExceptSelf(test);
        for (int val : ans) {
            System.out.println(val);
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        // 构建一个左、右侧所有数字乘积的数组
        // 先构建左侧所有数字的乘积数组
        int[] left = new int[nums.length];
        left[0] = 1;// 第一个数左边没有数，因此是 1
        for (int i = 1;i < nums.length;i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        // 再构建右侧所有数字的乘积数组
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;// 最后一个数右边没有数，因此是 1
        for (int i = nums.length-2;i >= 0;i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0;i < nums.length;i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

}