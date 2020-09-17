package Leetcode;

/**
 * [268] 缺失数字
 */
public class Question268_2 {
    public static void main(String[] args) {
        /*
            输入: [9,6,4,2,3,5,7,0,1]
            输出: 8
         */
        int[] test = new int[] {9,6,4,2,3,5,7,0,1};
        int  ans = missingNumber(test);
        System.out.println(ans);
    }

    private static int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        int realSum = 0;
        for (int val : nums) {
            realSum += val;
        }

        return sum - realSum;
    }
}