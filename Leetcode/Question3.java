package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [3] 无重复字符的最长子串
 */
public class Question3 {
    public static void main(String[] args) {
        String test = "pwwkew";
        int ans = lengthOfLongestSubstring(test);
        System.out.println(ans);
    }

    // 暴力法
    private static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0;i < s.length();i++) {
            Map<String, String> lookup = new HashMap<>();

            for (int j = i;j < s.length();j++) {
                String ch = s.substring(j, j+1);
                if (! lookup.containsKey(ch)) {
                    lookup.put(ch, ch);
                } else {
                    break;
                }
            }

            if (lookup.size()>ans) ans = lookup.size();
        }

        return ans;
    }

}