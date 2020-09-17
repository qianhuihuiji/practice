package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [448] 找到所有数组中消失的数字
 */
public class Question448 {
    public static void main(String[] args) {
        /*
            输入:
            [4,3,2,7,8,2,3,1]
            输出:
            [5,6]
         */
        int[] nums = new int[] {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDisappearedNumbers(nums);
        ans.forEach(System.out::println);
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for (int val : nums) {
            count[val] = 1;
        }

        for (int i = 1;i < count.length;i++) {
            if (count[i] == 0) ans.add(i);
        }

        return ans;
    }
}