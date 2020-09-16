package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [169] 多数元素
 */
public class Question169 {
    public static void main(String[] args) {
        int[] test = new int[] {3,2,3};
        int ans = majorityElement(test);
        System.out.println(ans);
    }

    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int half = nums.length / 2;

        for (int num : nums) {
            int count = lookup.getOrDefault(num, 0);
            lookup.put(num, ++count);

            if (count > half) return num;
        }

        return 0;
    }
}