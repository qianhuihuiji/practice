package Leetcode;

public class Question374 {
    public static void main(String[] args) {
        int answer = guessNumber(7);
        System.out.println(answer);
    }

    private static int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (guess(mid) < 0) {
                hi = mid - 1;
            } else if (guess(mid) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    public static int guess(int n) {
        if (n > 5) return -1;
        else if (n < 5) return 1;
        else return 0;
    }
}