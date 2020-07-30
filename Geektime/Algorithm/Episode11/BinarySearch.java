package Geektime.Algorithm.Episode11;

/**
 * 二分查找（下）：如何快速定位IP对应的省份地址 {@link @https://time.geekbang.org/column/article/42733}
 *
 * @author nofirst
 * @date 2020-07-30 11:01
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] test1 = new int[] {1,3,4,5,6,8,8,8,11,18};
        System.out.println("第一个值等于给定值的元素的下标是：" + bsearch1(test1, test1.length, 8));
        System.out.println("最后一个值等于给定值的元素的下标是：" + bsearch2(test1, test1.length, 8));
    }

    /**
     * 查找第一个值等于给定值的元素
     */

    private static int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid-1] != value) return mid;
                else high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */

    private static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || a[mid+1] != value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */

    private static int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else {
                // 能进入这里的前提是 a[mid] >= value
                if (mid == 0 || a[mid - 1] < value) return mid;
                else high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */

    private static int bsearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                // 能进入这里的前提是 a[mid] <= value
                if (mid == n - 1 || a[mid+1] > value) return mid;
                else low = mid + 1;
            }
        }

        return -1;
    }
}
