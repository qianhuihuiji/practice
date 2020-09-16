package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [118] 杨辉三角
 */
public class Question118 {
    public static void main(String[] args) {
//        输入: 5
//        输出:
//        [
//             [1],
//            [1,1],
//           [1,2,1],
//          [1,3,3,1],
//         [1,4,6,4,1]
//        ]

        List<List<Integer>> ans = generate(5);

        for (List<Integer> list : ans) {
            for (Integer value : list) {
                System.out.println(value);
            }

            System.out.println("end of line");
        }
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        int i = 1;
        while (i <= numRows) {
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

        return ans;
    }
}