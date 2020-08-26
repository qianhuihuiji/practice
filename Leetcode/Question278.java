package Leetcode;

public class Question278 {
    public static void main(String[] args) {
        int answer = firstBadVersion(1);
        System.out.println(answer);
    }

    private static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static boolean isBadVersion(int n) {
        return n == 1;
    }
}