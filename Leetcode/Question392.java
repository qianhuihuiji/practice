package Leetcode;

import java.util.Stack;

/**
 * [392] 判断子序列
 */
public class Question392 {
    public static void main(String[] args) {
        /*
            示例 1:
            s = "abc", t = "ahbgdc"
            返回 true.
         */

        String s = "axc";
        String t = "ahbgdc";

        boolean ans = isSubsequence(s, t);
        System.out.println(ans);
    }

    private static boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int left = 0;

        for (char ch : ss) {
            int firstPosition = firstPosition(left, tt, ch);

            if (firstPosition < 0) {
                return false;
            } else {
                left = firstPosition + 1;
            }
        }

        return true;
    }

    private static int firstPosition(int left, char[] chars, char ch) {
        int length = chars.length;
        for (int i = left;i < length;i++) {
            if (ch == chars[i]) return i;
        }

        return -1;
    }
}