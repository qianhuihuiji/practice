package Leetcode;

/**
 * [72] 编辑距离
 */
public class Question72 {
    public static void main(String[] args) {
        int answer = minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically");
        System.out.println(answer);
    }


    private static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] state = new int[l1][l2];

        // 处理第一行
        for (int i = 0;i < l2; i++) {
            if (i == 0) {
                if (w2[i] == w1[0]) state[0][i] = 0;
                else state[0][i] = 1;
            } else {
                if (w2[i] == w1[0]) state[0][i] = i;
                else state[0][i] = state[0][i-1] + 1;
            }
        }

        // 处理第一列
        for (int i = 0;i < l1; i++) {
            if (i == 0) {
                if (w1[i] == w2[0]) state[i][0] = 0;
                else state[i][0] = 1;
            } else {
                if (w1[i] == w2[0]) state[i][0] = i;
                else state[i][0] = state[i-1][0] + 1;
            }
        }

        for (int i = 1;i < l1;i++) {
            for (int j = 1;j<l2;j++) {
                if (w1[i] == w2[j]) {
                    state[i][j] = min(state[i-1][j-1], state[i-1][j] + 1, state[i][j-1] + 1);
                } else {
                    state[i][j] = min(state[i-1][j-1]+1, state[i-1][j] + 1, state[i][j-1] + 1);
                }
            }
        }

        return state[l1-1][l2-1];
    }


    public static int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j-1]+1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i-1][0]+1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) minDist[i][j] = min(
                        minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]);
                else minDist[i][j] = min(
                        minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]+1);
            }
        }
        return minDist[n-1][m-1];
    }

    private static int min(int a, int b, int c) {
        int min = Integer.MAX_VALUE;

        if (a < min) min = a;

        if (b < min) min = b;

        if (c < min) min = c;

        return min;
    }
}