package Leetcode;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * [260] 只出现一次的数字 III
 */
public class Question260 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,1,3,2,5};

        int[] ans = singleNumber(nums);

        for (int val : ans) {
            System.out.println(val);
        }
    }

    private static int[] singleNumber(int[] nums) {
        int[] ans = new int[2];

        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            if (values.contains(num)) values.remove(num);
            else values.add(num);
        }

        Iterator<Integer> iterator = values.iterator();
        ans[0] = iterator.next();
        ans[1] = iterator.next();

        return ans;
    }
}