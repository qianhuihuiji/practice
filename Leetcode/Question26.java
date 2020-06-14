package Leetcode;

public class Question26 {
    public static void main(String[] args) {
        int[] test = new int[] {0,0,1,1,1,2,2,3,3,4};
        int ans = removeDuplicates(test);
        System.out.println();
        System.out.println(ans);
        for (int i = 0;i < ans;i++) {
            System.out.println(test[i]);
        }
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1;j < nums.length;j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                System.out.print("当前：j=" + j + " ");
                printArr(nums);
            }
        }

        return i + 1;
    }

    private static void printArr(int[] arr) {
        for (int a: arr
             ) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}