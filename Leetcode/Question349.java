package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question349 {
    public static void main(String[] args) {
        int [] arr1 = {2, 7, 11, 15};
        int [] arr2 = {2, 7, 11, 15};

        int [] answer = intersection(arr1, arr2);

        // 打印所有数组元素
        for (int a : answer) {
            System.out.println(a);
        }
    }


    private static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int a : nums1.length >= nums2.length ? nums2 : nums1) {
            if (! dict.containsKey(a)) {
                dict.put(a, a);
            }
        }

        Map<Integer, Integer> ansMap = new HashMap<>();
        for (int a : nums1.length >= nums2.length ? nums1 : nums2) {
            if (dict.containsKey(a) && ! ansMap.containsKey(a)) {
                ansMap.put(a, a);
            }
        }

        int[] ans = new int[ansMap.size()];
        int i = 0;
        for (Integer a:ansMap.keySet()) {
            ans[i++] = a;
        }

        return ans;
    }
}