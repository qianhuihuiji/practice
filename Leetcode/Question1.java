package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question1 {
    public static void main(String[] args) {
        int [] testArr = {2, 7, 11, 15};
        int target = 9;


        int [] answer = twoSum(testArr,target);




        // 打印所有数组元素
        for (int a : answer) {
            System.out.println(a);
        }
    }


    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement),i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }

}