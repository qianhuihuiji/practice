package Leetcode;

public class Question26 {
    public static void main(String[] args) {
        int[] test = new int[] {0,0,0,1,1,1,2,2,3,3,4};
        int ans = removeDuplicates(test);
        System.out.println();
        System.out.println(ans);
        for (int i = 0;i < ans;i++) {
            System.out.println(test[i]);
        }
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int i = 0;
        for (int j = 1;j < nums.length;j++) {
            if (nums[i] != nums[j]) {
                // 一旦两者不相等，说明 i 的右边需要换成新的值，因此 i++
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}