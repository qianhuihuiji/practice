package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [3] 无重复字符的最长子串
 */
public class Question3_2 {
    public static void main(String[] args) {
        String test = "pwwkew";
        int ans = lengthOfLongestSubstring(test);
        System.out.println(ans);
    }

    // 滑动窗口
    private static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<String, Integer> lookup = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = s.length();
        while (left < length && right < length) {
            String sub = s.substring(right, right+1);
            while (! lookup.containsKey(sub)) {
                lookup.put(sub, 1);
                right++;
                if (right == length) {
                    break;
                }  else {
                    sub = s.substring(right, right+1);
                }
            }

            if (lookup.size() > ans) ans = lookup.size();

            // 向后滑动
            String subLeft = s.substring(left, left+1);
            lookup.remove(subLeft);
            left++;
        }

        return ans;
    }

}