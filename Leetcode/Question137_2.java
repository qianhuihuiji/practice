package Leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * [136] 只出现一次的数字 II
 */
public class Question137_2 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,1,2,1,2,1,99};

        int ans = singleNumber(nums);

        System.out.println(ans);
    }

    private static int singleNumber(int[] nums) {
        long sumArr = 0;
        Set<Long> values = new HashSet<>();
        for (int val : nums) {
            sumArr += val;
            values.add((long)val);
        }

        long sumValues = 0;
        for (long num: values){
            sumValues += num;
        }

        return (int)((3 * sumValues - sumArr) / 2);
    }
}