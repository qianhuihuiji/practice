package Leetcode;

public class Question1122 {
    public static void main(String[] args) {
        int [] arr1 = {1000,738,738};
        int [] arr2 = {738};

        int[] answer = relativeSortArray(arr1, arr2);
        for (int c: answer ) {
            System.out.println(c);
        }
    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2){
        // 计数数组，并且值是 index，且天然有序
        int[] count = new int[1001];
        for (int c : arr1) {
            count[c]++;
        }

        int[] ans = new int[arr1.length];
        int index = 0;

        for (int value : arr2) {
            for (int j = 0; j < count[value]; j++) {
                ans[index++] = value;
            }

            // 将计数数组对应的 key 复位
            count[value] = 0;
        }

        for (int i = 0; i <= 1000; i++) {
            // 大于 0 说明是 arr1 里面的元素
            if (count[i] > 0) {
                for (int j = 0;j < count[i];j++) {
                    ans[index++] = i;
                }
            }

        }

        return ans;
    }
}