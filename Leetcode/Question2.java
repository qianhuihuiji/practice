package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question2 {
    public static void main(String[] args) {
        int test = 1534236469;

        System.out.println(reverse(test));
    }


    private static int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            // 下面这行代码是进行越界判断
            // 如果 ans * 10 越界，那么 ans * 10 / 10 就会丢失精度，也就不会等于 ans
            // 那么，会存在 ans * 10 不越界，但是 ans * 10 + x % 10 越界的情况吗？
            // 答案是不会，因为 ans * 10 不越界，那么 ans * 10 的个位是 0，而 x % 10 的取值是 0 到 9，不会进位
            if(ans * 10 / 10 != ans) {
                ans = 0;

                break;
            }

            ans = ans * 10 + x % 10;
            x /= 10;
        }

        return ans;
    }
}