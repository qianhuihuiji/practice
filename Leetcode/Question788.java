package Leetcode;

public class Question788 {
    public static void main(String[] args) {
        int  answer = rotatedDigits(10);

        System.out.println(answer);
    }

    private static int rotatedDigits(int N) {
        int count = 0;

        for (int i = 1;i <= N;i++) {
            if (isGood(i, false)) count++;
        }

        return count;
    }

    private static boolean isGood(int n, boolean flag) {
        if (n == 0) return flag;

        // 判断个位数的数是不是好数
        int d = n % 10;
        // 包含 3、4、7 的数都不是好数，所以明确知道返回 false，不继续递归
        if (d == 3 || d == 4 || d == 7) return false;
        // 包含 0、1、8 的数都不能确定是不是好数，所以用上一个位数的 flag，继续递归判断
        if (d == 0 || d == 1 || d == 8) return isGood(n / 10, flag);

        // 剩余的明确知道是好数，所以使用 flag 为 true，继续下一位数的递归
        return isGood(d / 10, true);
    }
}