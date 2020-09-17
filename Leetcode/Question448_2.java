package Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [448] 找到所有数组中消失的数字
 */
public class Question448_2 {
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
        List<Integer> ans = new LinkedList<>();
        // 与题解 1 类似思路，使用计数数组，但是这次是利用 nums 本身做计数数组
        // 但是需要特别注意的一点是，在这里我们需要保存原始数据的信息，所以使用相反数是个极佳的选择
        // 既能做标记，又能保留原始数据的信息
        // 数组下标减去 1，即对应原始的数值
        for (int val : nums) {
            // 前面的遍历可能会把后面的数据修改成负数
            int index = Math.abs(val) - 1;

            nums[index] =  -Math.abs(nums[index]);
        }

        for (int i = 0;i < nums.length;i++) {
            if (nums[i] > 0) ans.add(i+1);
        }
        return ans;
    }
}