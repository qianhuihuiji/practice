package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [238] 除自身以外数组的乘积
 */
public class Question238 {
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

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0;j < nums.length;j++) {
                if (i != j) product *= nums[j];
            }

            ans[i] = product;
        }

        return ans;
    }

}