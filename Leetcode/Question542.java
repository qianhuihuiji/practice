package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * [542] 01 矩阵
 */
public class Question542 {
    public static void main(String[] args) {
        /*
            输入:
                0 0 0
                0 1 0
                1 1 1
            输出:
                0 0 0
                0 1 0
                1 2 1
         */
        int[][] nums = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ans = updateMatrix(nums);
        for (int[] list : ans) {
            for (int val : list) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }

    private static int[][] updateMatrix(int[][] matrix) {
        int[][] ans = matrix;

        return ans;
    }
}