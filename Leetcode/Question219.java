package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [219] 存在重复元素II
 */
public class Question219 {
    public static void main(String[] args) {
//        int[] test = new int[] {1,2,3,1};
        int[] test = new int[] {1,2,3,1,2,3};
        boolean ans = containsDuplicate(test, 2);
        System.out.println(ans);
    }

    private static boolean containsDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lookup = new HashMap<>();
        Map<Integer, Integer> indexLookup = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            int num = nums[i];
            int count = lookup.getOrDefault(num, 0);
            lookup.put(num, ++count);

            if (count > 1) {
                int index = indexLookup.getOrDefault(num, i);
                if (i - index <= k) {
                    return true;
                } else {
                    lookup.put(num, 1);
                }
            }

            // 记录出现的位置
            indexLookup.put(num, i);
        }
        return false;
    }
}