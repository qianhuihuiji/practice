package Leetcode;

public class Question27 {
    public static void main(String[] args) {
        int[] test = new int[] {2};
        int ans = removeElement(test, 3);
        System.out.println();
        System.out.println(ans);
        for (int i = 0;i < ans;i++) {
            System.out.println(test[i]);
        }
    }

    private static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = nums.length - 1;j >= i;j--) {
            if (nums[j] == val) continue;

            while (i < nums.length && nums[i] != val ) {
                i++;
            }

            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        return i;
    }
}