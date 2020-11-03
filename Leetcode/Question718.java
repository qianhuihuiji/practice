package Leetcode;

/**
 * [718] 最长重复子数组
 */
public class Question718 {
    public static void main(String[] args) {
        /*
            输入：
            A: [1,2,3,2,1]
            B: [3,2,1,4,7]
            输出：3
            解释：
            长度最长的公共子数组是 [3, 2, 1] 。
         */

        int[] a = new int[] {0,0,0,0,0,0,1,0,0,0};
        int[] b = new int[] {0,0,0,0,0,0,0,1,0,0};

        int ans = findLength(a, b);
        System.out.println(ans);
    }

    private static int findLength(int[] A, int[] B) {
        int maxSub = 0;
        for (int i = 0;i < A.length;i++) {
            int tmpMax = maxSubLength(A,B,i);

            if (tmpMax > maxSub) maxSub = tmpMax;
        }

        return maxSub;
    }

    private static int maxSubLength(int[] A, int[] B, int index) {
        int maxSub = 0;

        for (int i = 0;i < B.length;i++) {
            int tmpJ = index;
            int tmpI = i;
            int tmpMax = 0;
            while (tmpJ < A.length && tmpI < B.length && A[tmpJ] == B[tmpI]) {
                tmpI++;
                tmpJ++;
                tmpMax++;
            }

            if (tmpMax > maxSub) maxSub = tmpMax;
        }

        return maxSub;
    }
}