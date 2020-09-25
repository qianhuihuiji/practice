package Leetcode;

/**
 * [74] 搜索二维矩阵
 */
public class Question74 {
    public static void main(String[] args) {
        int[][] test = new int[][] {{-8,-7,-5,-3,-3,-1,1}};
        boolean ans = searchMatrix(test, -5);
        System.out.println(ans);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        if (matrix[0].length == 0) return false;

        // 先找到在哪行
        int left = 0, right = matrix.length - 1, ans = matrix.length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target < matrix[mid][0]) {
                ans = mid;
                right = mid - 1;
            } else if (target > matrix[mid][0]) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        // 如果没找到
        if (ans - 1 < 0) return false;

        // 在对应的行里找，即第 ans 行，对应下标是 n-1
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target < matrix[ans-1][mid]) {
                right = mid - 1;
            } else if (target > matrix[ans-1][mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}