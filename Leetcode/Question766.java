package Leetcode;

/**
 * [766] 托普利茨矩阵
 */
public class Question766 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};

        boolean ans = isToeplitzMatrix(matrix);
        System.out.println(ans);
    }

    private static boolean isToeplitzMatrix(int[][] matrix) {
        // 依次与左上邻居对比，有不相等即为 false
        for (int i = 1;i < matrix.length;i++) {
            for (int j = 1;j < matrix[0].length;j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) return false;
            }
        }

        return true;
    }
}