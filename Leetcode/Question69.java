package Leetcode;

public class Question69 {
    public static void main(String[] args) {
        int answer = mySqrt(2147395599);
        System.out.println(answer);
    }

    private static int mySqrt(int x) {
        int maxIntSqrt = 46340;
        int low = 1;
        int high = x >= maxIntSqrt ? maxIntSqrt : x;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            int xx = middle * middle;
            System.out.println(low + "," + high + "," + xx);
            if (xx < x) {
                low = middle + 1;
            } else if (xx > x) {
                high = middle - 1;
            } else {
                return middle;
            }
        }

        return low - 1;
    }
}