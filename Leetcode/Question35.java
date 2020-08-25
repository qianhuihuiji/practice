package Leetcode;

public class Question35 {
    public static void main(String[] args) {
        int[] test = new int[] {1};
        int ans = searchInsert(test, 1);
        System.out.println(ans);
    }

    private static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;

        // 只有 1 个元素不会进入此逻辑
        while (low < high) {
            int middle = (low + high) >> 1;
            if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }

        // >= 是兼容一个元素的数组
        return nums[low] >= target ? low : low + 1;
    }
}