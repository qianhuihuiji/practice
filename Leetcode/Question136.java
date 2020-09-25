package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [136] 只出现一次的数字
 */
public class Question136 {
    public static void main(String[] args) {
        int[] nums = new int[] {4,1,2,1,2};

        int ans = singleNumber(nums);

        System.out.println(ans);
    }

    private static int singleNumber(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            if (values.contains(num)) values.remove(num);
            else values.add(num);
        }

        return values.iterator().next();
    }
}