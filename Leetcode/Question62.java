package Leetcode;

/**
 * [62] 不同路径
 */
public class Question62 {
    public static void main(String[] args) {
        int ans = uniquePaths(3,2);
        System.out.println(ans);
    }

    private static int uniquePaths(int m, int n) {
        int[][] states = new int[m][n];
        for (int j = 0; j < n; ++j) { // 初始化states的第一行数据，第一行数据只能通过右移得到
            states[0][j] = 1;
        }
        for (int i = 0; i < m; ++i) { // 初始化states的第一列数据，第一列数据只能通过下移得到
            states[i][0] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                states[i][j] = states[i][j-1] + states[i-1][j];
            }
        }

        return states[m-1][n-1];
    }
}