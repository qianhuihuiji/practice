package Leetcode;

/**
 * [88] 合并两个有序数组
 */
public class Question88 {
    public static void main(String[] args) {
        int[] test1 = new int[] {1,2,3,0,0,0};
        int[] test2 = new int[] {2,5,6};
        merge(test1, 3, test2, 3);
        for (int value : test1) {
            System.out.println(value);
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[nums1.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                ans[index++] = nums1[i++];
            } else {
                ans[index++] = nums2[j++];
            }
        }

        // 如果 nums1 没有被合并完
        while (i < m) {
            ans[index++] = nums1[i++];
        }


        // 如果 nums2 没有被合并完
        while (j < n) {
            ans[index++] = nums2[j++];
        }

        for (int p = 0;p < ans.length;p++) {
            nums1[p] = ans[p];
        }
    }
}