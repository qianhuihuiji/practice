package Leetcode;

/**
 * [238] 除自身以外数组的乘积
 */
public class Question238_3 {
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
        // 直接利用 ans 做左侧乘积的数据
        // 然后从右侧开始计算 ans，并且临时保存右侧所有数字乘积即可，因为它只使用一次
        ans[0] = 1;// 第一个数左边没有数，因此是 1
        for (int i = 1;i < nums.length;i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        // 临时保存右侧所有数字的乘积
        int right = 1;// 最后一个数右边没有数，因此是 1
        for (int i = nums.length-1;i >= 0;i--) {
            ans[i] = ans[i] * right;

            right = nums[i] * right;
        }

        return ans;
    }

}