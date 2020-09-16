package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [189] 旋转数组
 */
public class Question189 {
    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,1};
        rotate(test, 3);
        for (int val : test) {
            System.out.println(val);
        }
    }

    private static void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];

        k = k % nums.length;

        int steps = k;
        for (int i = 0;i < k;i++) {
            ans[i] = nums[nums.length - steps];
            steps--;
        }

        int j = 0;
        while (k < nums.length){
            ans[k] = nums[j++];
            k++;
        }

        System.arraycopy(ans, 0, nums, 0, ans.length);
    }
}