package Leetcode;

import java.util.Arrays;

public class Question475 {
    public static void main(String[] args) {
        int [] arr1 = {1,5};
        int [] arr2 = {2};

        int  answer = findRadius(arr1, arr2);

        System.out.println(answer);
    }

    private static int findRadius(int[] houses, int[] heaters) {
        int min = 0;

        Arrays.sort(heaters);

        for (int house : houses) {
            int left = 0;
            int right = heaters.length;

            // 找到第一个大于等于 house 位置的热水器
            while (left < right) {
                int mid = left + ((right - left) >>> 1) ;
                if (house > heaters[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 找到的热水器与 house 的距离
            // 如果 right 等于 heaters.length，那说明 house 的右边不存在热水器，则与右边热水器的距离视为 Integer.MAX_VALUE
            // 此情况下，左边的热水器是最后一个热水器，与之的距离即为最小距离
            int distanceRight = right == heaters.length ? Integer.MAX_VALUE : heaters[right] - house;
            // 找到的热水器的左边一个热水器与 house 的距离
            // 如果 right 等于 0，那说明 house 的左边不存在热水器，则与左边热水器的距离视为 Integer.MAX_VALUE
            // 此情况下，右边的热水器是第一个热水器，与之的距离即为最小距离
            int distanceLeft = right == 0 ? Integer.MAX_VALUE : house - heaters[right - 1];

            // 比较左右两边热水器的距离，取小者
            int tmpMin = distanceLeft > distanceRight ? distanceRight : distanceLeft;

            if (tmpMin > min) min = tmpMin;
        }

        return min;
    }
}