package Leetcode;

public class Question892 {
    public static void main(String[] args) {
        int [][] arr = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};

        int answer = surfaceArea(arr);

        System.out.println(answer);
    }

    private static int surfaceArea(int[][] grid) {
        int count = 0, cover = 0;

        for (int i = 0; i < grid.length; i ++) {
            int[] y = grid[i];
            for (int j = 0; j < y.length; j++) {
                // 计算count
                int value = grid[i][j];
                count += value;

                // 计算垂直方向上被盖住的面
                cover += value > 1 ? (value - 1) * 2 : 0;

                // 计算水平方向上被盖住
                // 有两种可能：横向和竖向
                // 计算横向被盖住的面
                if (i < grid.length - 1) {
                    cover += Math.min(grid[i][j], grid[i+1][j]) * 2;
                }
                // 计算竖向被盖住的面
                if (j < y.length - 1) {
                    cover += Math.min(grid[i][j], grid[i][j+1]) * 2;
                }
            }
        }

        return 6 * count - cover;
    }
}