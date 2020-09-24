package Leetcode;

import java.util.Stack;

/**
 * [150] 逆波兰表达式求值
 */
public class Question150 {
    public static void main(String[] args) {
        /*
            输入: ["2", "1", "+", "3", "*"]
            输出: 9
         */

        String[] tokens = new String[] {"2", "1", "+", "3", "*"};

        int ans = evalRPN(tokens);
        System.out.println(ans);
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    Integer pre = nums.pop();
                    Integer prePre = nums.pop();
                    nums.push(prePre + pre);
                    break;
                case "-":
                    pre = nums.pop();
                    prePre = nums.pop();
                    nums.push(prePre - pre);
                    break;
                case "*":
                    pre = nums.pop();
                    prePre = nums.pop();
                    nums.push(prePre * pre);
                    break;
                case "/":
                    pre = nums.pop();
                    prePre = nums.pop();
                    nums.push(prePre / pre);
                    break;
                default:
                    nums.push(Integer.valueOf(token));
                    break;
            }
        }

        return nums.peek();
    }
}