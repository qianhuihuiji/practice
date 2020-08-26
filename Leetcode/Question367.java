package Leetcode;

public class Question367 {
    public static void main(String[] args) {
        boolean answer = isPerfectSquare(16);

        System.out.println(answer);
    }

    private static boolean isPerfectSquare(int num) {
        int maxIntSqrt = 46340;
        int low = 1;
        int high = num >= maxIntSqrt ? maxIntSqrt : num;

        while (low < high) {
            int middle = (low + high) >> 1;
            int xx = middle * middle;
            if (xx < num) {
                low = middle + 1;
            } else if (xx > num) {
                high = middle - 1;
            } else {
                return true;
            }
        }

        return low * low == num;
    }
}