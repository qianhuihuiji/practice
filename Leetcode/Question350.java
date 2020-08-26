package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question350 {
    public static void main(String[] args) {
        int [] arr1 = {1,2,2,1};
        int [] arr2 = {2};

        int [] answer = intersection(arr1, arr2);

        // 打印所有数组元素
        for (int a : answer) {
            System.out.println(a);
        }
    }


    private static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int a : nums1.length >= nums2.length ? nums2 : nums1) {
            if (dict.containsKey(a)) {
                int val = dict.get(a);
                dict.put(a, val + 1);
            } else {
                dict.put(a, 1);
            }
        }

        Map<Integer, Integer> ansMap = new HashMap<>();
        for (int a : nums1.length >= nums2.length ? nums1 : nums2) {
            if (dict.containsKey(a)) {
                int val = dict.get(a);

                if (ansMap.containsKey(a)) {
                    int ansVal = ansMap.get(a);

                    if (val > 0) {
                        ansMap.put(a, ansVal + 1);
                    }
                } else {
                    ansMap.put(a, 1);
                }

                // 这里 ansVal 都会被设置一次值，相应的，val 要扣减一次
                dict.put(a, val - 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> key : ansMap.entrySet()) {
            int value = key.getValue();
            sum += value;
        }
        int[] ans = new int[sum];
        int i = 0;
        for (Integer a : ansMap.keySet()) {
            int val = ansMap.get(a);
            while (val > 0) {
                val--;
                ans[i++] = a;
            }
        }

        return ans;
    }
}