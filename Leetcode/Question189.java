package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [189] 旋转数组
 */
public class Question189 {
    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,1};
        boolean ans = containsDuplicate(test);
        System.out.println(ans);
    }

    private static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int num : nums) {
            int count = lookup.getOrDefault(num, 0);
            lookup.put(num, ++count);

            if (count > 1) return true;
        }
        return false;
    }
}