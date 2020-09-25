package Leetcode;

/**
 * [191] 位1的个数
 */
public class Question191_2 {
    public static void main(String[] args) {
        int ans = hammingWeight(7);

        System.out.println(ans);
    }

    private static int hammingWeight(int n) {
        int bits = 0;

        while (n != 0) {
            bits++;
            // 这个的技巧在于，n-1与n的最后一位，一个是 0，另一个就是 1
            // 如果 n 的最后一位是 1，那么 n-1 的最后一个则是 0，n & (n-1) 的结果就是将 n 的最后一位的 1 消去
            // 如果 n 的最后一位是 0，n-1 相当于右移一位，n & (n-1) 的结果就是将 n 的第一位的 1 消去
            n = n & (n-1);
        }

        return bits;
    }
}