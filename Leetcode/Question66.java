package Leetcode;

import java.util.Arrays;

/**
 * [66] 加一
 */
public class Question66 {
    public static void main(String[] args) {
        int[] test = new int[] {4,3,2,9};
        int[] ans = maxSubArray(test);
        for (int i = 0;i < ans.length;i++) {
            System.out.println(ans[i]);
        }
    }

    private static int[] maxSubArray(int[] digits) {
        // 末尾加 1
        digits[digits.length-1] = digits[digits.length-1] + 1;
        // 判断是否需要进位
        boolean supply = digits[digits.length-1] == 10;
        int i = digits.length - 1;
        while (supply && i > 0) {
            digits[i] = 0;
            i--;
            digits[i] = digits[i] + 1;

            supply = digits[i] == 10;
        }

        // 如果最终还需要补位，说明最高位原来是9，现在变成了10
        if (supply) {
            // 最高位置 0
            digits[0] = 0;

            int[] ans = new int[digits.length + 1];
            ans[0] = 1;

            for (int j = 1;j <= digits.length;j++) {
                ans[j] = digits[j-1];
            }

            return ans;
        }

        return digits;
    }
}