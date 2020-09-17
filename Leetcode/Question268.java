package Leetcode;

/**
 * [268] 缺失数字
 */
public class Question268 {
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
        int[] count = new int[nums.length + 1];
        for (int val : nums) {
            count[val] = 1;
        }

        for (int i = 0;i < count.length;i++) {
            if (count[i] == 0) return i;
        }

        return nums.length + 1;
    }
}