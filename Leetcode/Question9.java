package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }


    private static boolean isPalindrome(int x) {
        if (x < 0) return false;

        List<Integer> numbers = new ArrayList<>();
        while (x != 0) {
            numbers.add(x % 10);
            x /= 10;
        }

        System.out.println(numbers.toString());

        int lo = 0;
        int hi = numbers.size() - 1;

        while (numbers.get(lo).equals(numbers.get(hi))) {
            if( lo >= hi) return true;
            lo++;
            hi--;
        }

        return false;
    }
}