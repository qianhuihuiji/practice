package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [119] 杨辉三角II
 */
public class Question119 {
    public static void main(String[] args) {

        List<Integer> ans = getRow(3);

        for (Integer value : ans) {
            System.out.println(value);
        }
    }

    private static List<Integer> getRow(int rowIndex){
        List<List<Integer>> ans = new ArrayList<>();

        int i = 1;
        while (i <= rowIndex + 1) {
            List<Integer> lastList =  new ArrayList<>();

            if (ans.size() == 0) {
                lastList.add(1);
            } else {
                lastList = ans.get(i-2);
            }

            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0;j < i; j++) {
                int leftShoulderIndex = j - 1;
                int leftShoulder = leftShoulderIndex < 0 ? 0 : lastList.get(leftShoulderIndex);

                int rightShoulderIndex = j;
                int rightShoulder = rightShoulderIndex >= lastList.size() ? 0 : lastList.get(rightShoulderIndex);

                tmpList.add(leftShoulder + rightShoulder);
            }

            ans.add(tmpList);
            i++;
        }

        return ans.get(rowIndex);
    }
}