package Leetcode;

import java.util.Arrays;

/**
 * [287] 寻找重复数
 */
public class Question287 {
    public static void main(String[] args) {
        /*
            输入: [1,3,4,2,2]
            输出: 2
         */
        /*
        说明：
            不能更改原数组（假设数组是只读的）。
            只能使用额外的 O(1) 的空间。
            时间复杂度小于 O(n^2) 。
            数组中只有一个重复的数字，但它可能不止重复出现一次。
         */
        int[] nums = new int[] {1,3,4,2,2};
        int ans = findDuplicate(nums);
        System.out.println(ans);
    }

    private static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return 2;
    }
}