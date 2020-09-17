package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [228] 汇总区间
 */
public class Question228 {
    public static void main(String[] args) {
        /*
            输入: [0,1,2,4,5,7]
            输出: ["0->2","4->5","7"]
            解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
         */
        int[] test = new int[] {0,2,3,4,6,8,9};
        List<String> ans = summaryRanges(test);
        ans.forEach(System.out::println);
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (end == nums.length - 1) {
                addAns(nums, ans, start, end);
                break;
            }

            while (end < nums.length - 1 && nums[end+1] == nums[end] + 1) {
                end++;
            }

            addAns(nums, ans, start, end);

            end++;
            start = end;
        }

        return ans;
    }

    private static void addAns(int[] nums, List<String> ans, int start, int end) {
        if (start == end) {
            ans.add(nums[start] + "");
        } else {
            ans.add(nums[start] + "->" + nums[end]);
        }
    }
}