package Leetcode;

import java.util.Stack;

/**
 * [394] 字符串解码
 */
public class Question394 {
    public static void main(String[] args) {
        /*
            输入：s = "3[a2[c]]"
            输出："accaccacc"
         */

//        String s = "3[a]2[bc]";
        String s = "3[a2[c]]";
//        String s = "10[leetcode]";

        String ans = decodeString(s);
        System.out.println(ans);
    }

    private static String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strings = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];

            if (Character.isDigit(ch)) {
                String num = "";
                while (Character.isDigit(ch)) {
                    num += Character.toString(ch);
                    i++;
                    ch = chars[i];
                }

                nums.push(Integer.valueOf(num));
                continue;
            }

            // 遇到 ] 符号则看开始拼接答案
            if (ch == ']') {
                String tmpAns = "";
                String op = strings.pop();
                while (! op.equals("[")) {
                    tmpAns = op + tmpAns;
                    op = strings.pop();
                }

                // 取出数字栈的元素，解码
                int times = nums.pop();
                String tmp = tmpAns;
                for (int j = 1;j < times;j++) {
                    tmpAns += tmp;
                }

                strings.push(tmpAns);
                i++;

                continue;
            }

            // 其余入string栈
            strings.push(Character.toString(ch));
            i++;
        }

        String ans = "";
        while (! strings.isEmpty()) {
            ans = strings.pop() + ans;
        }

        return ans;
    }
}