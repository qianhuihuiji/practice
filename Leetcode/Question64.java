package Leetcode;

/**
 * [64] 最小路径和
 */
public class Question64 {
    public static void main(String[] args) {
        int[][] test = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        int ans = minPathSum(test);
        System.out.println(ans);
    }

    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] states = new int[m][n];
        int sum = 0;
        for (int j = 0; j < n; ++j) { // 初始化states的第一行数据，第一行数据只能通过右移得到
            sum += grid[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        for (int i = 0; i < m; ++i) { // 初始化states的第一列数据，第一列数据只能通过下移得到
            sum += grid[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                states[i][j] =
                        grid[i][j] + Math.min(states[i][j-1], states[i-1][j]);
            }
        }
        return states[m-1][n-1];
    }
}