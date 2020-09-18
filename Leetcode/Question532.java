package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * [532] 数组中的K-diff数对
 */
public class Question532 {
    public static void main(String[] args) {
        /*
            输入:[1, 2, 3, 4, 5], k = 1
            输出: 4
            解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
         */
        int[] nums = new int[] {0,0,0};
        int ans = findPairs(nums, 0);
        System.out.println(ans);
    }

    private static int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        AtomicInteger ans = new AtomicInteger();
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int val : nums) {
            lookup.put(val ,lookup.getOrDefault(val, 0) + 1);
        }

        lookup.keySet().forEach((key) -> {
            if (k == 0) {
                if (lookup.getOrDefault(key, 0) > 1) ans.getAndIncrement();
            } else { // k >0
                if (lookup.getOrDefault(key + k, 0) > 0) ans.getAndIncrement();
            }
        });

        return ans.get();
    }
}