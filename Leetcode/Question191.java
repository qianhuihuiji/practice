package Leetcode;

/**
 * [191] 位1的个数
 */
public class Question191 {
    public static void main(String[] args) {
        int ans = hammingWeight(7);

        System.out.println(ans);
    }

    private static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}