package Leetcode;

/**
 * [70] 爬楼梯
 */
public class Question70 {
    public static void main(String[] args) {
        int answer = climbStairs(3);
        System.out.println(answer);
    }

    // 单纯递归会超时
    private static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }
}