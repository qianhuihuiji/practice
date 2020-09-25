package Leetcode;


/**
 * [136] 只出现一次的数字 II
 */
public class Question137 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,1,2,1,2,1,99};

        int ans = singleNumber(nums);

        System.out.println(ans);
    }

    private static int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // 第一次进入循环时，seenOnce ^ num 的的值是 num, 此时 seenTwice 是 0，因此 seenOnce 的值是 num
            // seenTwice ^ num 的值是 num,但是此时 seenOnce 也是 num，因此得到的 seenTwice 是 0

            // 第二次循环时，如果值相同
            // 此时 seenOnce ^ num 为 0，并且此时的 seenTwice 是 0，因此 seenOnce 为 0
            // seenTwice ^ num 的值为 num，并且此时的 seenOnce 为 0，因此得到的 seenTwice 为 num

            // 第三次循环时，此时的 seenTwice 为 num，seenOnce ^ num 为 num，因此得到的 seenOnce 为 0
            // seenTwice 也为 0

            // 即，当一个位上面的数出现三次时，seenOnce 与 seenTwice 会被重置为 0
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }
}