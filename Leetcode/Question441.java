package Leetcode;

public class Question441 {
    public static void main(String[] args) {
        int answer = arrangeCoins(1804289383);

        System.out.println(answer);
    }

    private static int arrangeCoins(int n) {
        int low = 0;
        int high = n;

        while (low < high) {
            int middle = (low + high) >> 1;
            long xx = ((long)middle * (long)(middle + 1)) >> 1;
            if (xx < n) {
                long midRight = ((long)(middle + 1) * (long)(middle + 2)) >> 1;
                if (midRight > n) return middle;

                low = middle + 1;
            } else if (xx > n) {
                high = middle - 1;
            } else {
                return middle;
            }
        }

        return low ;
    }
}