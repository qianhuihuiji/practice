package Leetcode;

/**
 * [908] 最小差值 I
 */
public class Question908 {
    public static void main(String[] args) {
        int[] A = new int[]{0, 10};

        int ans = smallestRangeI(A, 2);
        System.out.println(ans);
    }

    private static int smallestRangeI(int[] A, int K) {
        int min = 10001;
        int max = -1;

        for (int a : A) {
            min = a <= min ? a : min;
            max = a >= max ? a : max;
        }

        int threshold = (max - min) - 2 * K;

        return threshold > 0 ? threshold : 0;
    }
}