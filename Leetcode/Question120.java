package Leetcode;

import java.util.*;

/**
 * [120] 三角形最小路径和
 */
public class Question120 {
    public static void main(String[] args) {
        int[][] nums = new int[][] {{-1}, {3,2}, {-3,1,-1}};
        List<List<Integer>> triangle = new ArrayList<>();

        for (int[] values : nums) {
            List<Integer> l = new ArrayList<>();
            for (int val : values) {
                l.add(val);
            }

            triangle.add(l);
        }

        int ans = minimumTotal(triangle);

        System.out.println(ans);
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1;i < triangle.size();i++) {
            List<Integer> upper = triangle.get(i-1);
            List<Integer> cur = triangle.get(i);

            for (int j = 0;j < cur.size();j++) {
                int left = j == 0 ? Integer.MAX_VALUE : upper.get(j-1) + cur.get(j);
                int middle = j == cur.size()-1 ? Integer.MAX_VALUE : upper.get(j) + cur.get(j);

                cur.set(j, min(left, middle));
            }
        }


        int ans = Integer.MAX_VALUE;

        for (Integer num: triangle.get(triangle.size()-1)) {
            if (num < ans) ans = num;
        }

        return ans;
    }

    private static int min(int a, int b) {
        int min = Integer.MAX_VALUE;

        if (a < min) min = a;
        if (b < min) min = b;

        return min;
    }
}