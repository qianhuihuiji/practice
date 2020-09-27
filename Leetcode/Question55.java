package Leetcode;

/**
 * [55] 跳跃游戏
 */
public class Question55 {
    public static void main(String[] args) {
//        int[] test = new int[] {2,3,1,1,4};
        int[] test = new int[] {3,2,1,0,4};
//        int[] test = new int[] {1,1,1,0};
        boolean ans = canJump(test);
        System.out.println(ans);
    }

    private static boolean canJump(int[] nums) {
        int length = nums.length;

        if (length == 1 && nums[0] >= 0) return true;

        boolean[] states = new boolean[length];
        // 初始化第一个数据
        for (int i = 0;i <= nums[0];i++) {
            // 已经跳到最后一个了
            if (i >= length) return true;

            states[i] = true;
        }

        for (int j = 1;j < length;j++) {
            int steps = nums[j];

            if (states[j] && steps > 0) {
                for (int i = 1;i <= steps;i++) {
                    // 已经跳到最后一个了
                    if (j+i >= length) return true;

                    states[j+i] = true;
                }
            }
        }

        return states[length-1];
    }
}