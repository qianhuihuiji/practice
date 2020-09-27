package Leetcode;

/**
 * [62] 不同路径
 */
public class Question63 {
    public static void main(String[] args) {
        int[][] test = new int[][] {{0,1}};
        int ans = uniquePathsWithObstacles(test);
        System.out.println(ans);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] states = new int[m][n];
        // 初始化第一个
        states[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int j = 1; j < n; ++j) { // 初始化states的第一行数据，第一行数据只能通过右移得到

            if (obstacleGrid[0][j] == 1) {
                states[0][j] = 0;
            } else {
                states[0][j] = states[0][j-1];
            }
        }
        for (int i = 1; i < m; ++i) { // 初始化states的第一列数据，第一列数据只能通过下移得到
            if (obstacleGrid[i][0] == 1) {
                states[i][0] = 0;
            } else {
                states[i][0] = states[i-1][0];
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    states[i][j] = 0;
                } else {
                    states[i][j] = states[i][j-1] + states[i-1][j];
                }
            }
        }

        return states[m-1][n-1];
    }
}