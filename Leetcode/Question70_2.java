package Leetcode;

/**
 * [70] 爬楼梯
 */
public class Question70_2 {
    public static void main(String[] args) {
        int answer = climbStairs(3);
        System.out.println(answer);
    }

    // 滚动数组的思想
    private static int climbStairs(int n) {
        int p , q = 0, r = 1;
        for (int i = 0;i < n;i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }
}