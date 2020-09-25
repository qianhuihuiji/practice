package Leetcode;

/**
 * [136] 只出现一次的数字
 */
public class Question136_2 {
    public static void main(String[] args) {
        int[] nums = new int[] {4,1,2,1,2};

        int ans = singleNumber(nums);

        System.out.println(ans);
    }

    private static int singleNumber(int[] nums) {
        int ans = 0;
        for (int val : nums) {
            ans ^= val;
        }

        return ans;
    }
}