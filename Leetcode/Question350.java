package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question350 {
    public static void main(String[] args) {
        int [] arr1 = {1,2,2,1};
        int [] arr2 = {2,2};

        int [] answer = intersection(arr1, arr2);

        // 打印所有数组元素
        for (int a : answer) {
            System.out.println(a);
        }
    }


    private static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> dict = new HashMap<>();
        boolean nums1IsSmaller = nums1.length <= nums2.length;

        // 以小数组构建lookup
        for (int a : nums1IsSmaller ? nums1 : nums2) {
            int count = dict.getOrDefault(a, 0) + 1;
            dict.put(a, count);
        }

        int[] ans = nums1IsSmaller ? new int[nums1.length] : new int[nums2.length];

        // 遍历大数组
        int index = 0;
        for (int a : nums1IsSmaller ? nums2 : nums1) {
            int count = dict.getOrDefault(a, 0);

            if (count > 0) {
                dict.put(a, --count);
                ans[index++] = a;
            } else {
                dict.remove(a);
            }
        }

        return Arrays.copyOfRange(ans, 0, index);
    }
}