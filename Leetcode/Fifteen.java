package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fifteen {
    public static void main(String[] args) {
        Integer [] testArr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> answer = threeSum(testArr);

        Integer aa = 120;


        boolean positive = true;
        if(aa < 0) {
            positive =false;
            aa = -aa;
        }

        Integer bitcount = 0;
        Map<Integer,Integer> result = new HashMap<>();
        while ( aa > 0) {
            result.put(bitcount,aa % 10);
            bitcount++;
            aa = aa / 10;
        }
        Double value = 0.0;
        for (int j=0;j<bitcount;j++) {
            value += result.get(j) * Math.pow(Double.valueOf(10),Double.valueOf(bitcount -j-1));
        }

        System.out.println(positive ? value.intValue() : - value.intValue());

        // 打印所有数组元素
//        for (List a : answer) {
//            System.out.println(a);
//        }
    }


    private static List<List<Integer>> threeSum(Integer[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        return a;
    }

}