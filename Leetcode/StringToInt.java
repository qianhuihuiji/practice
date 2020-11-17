package Leetcode;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-11-16 19:04
 */
public class StringToInt {
    public static void main(String[] args) throws Exception{
        String test = "124";

        System.out.println(toInt(test));
    }

    private static int toInt(String input) throws Exception{
        // 格式校验
        // 考虑负数情况
        char[] chars = input.toCharArray();
        int[] nums = new int[chars.length];
        int i = 0;
        boolean negative = false;
        for (char ch : chars) {
            if (!negative && ch == '-') {
                negative = true;
                continue;
            }
            if (! Character.isDigit(ch)) {
                throw new  Exception("not digit");
            }
            nums[i++] = translateToSingleNum(ch);
        }
        // 溢出校验
        // "123" ==> [1,2,3]
        long total = 0;
        int j = 1;
        for (int number : nums) {
            if (negative) {
                if (total > Integer.MAX_VALUE - 1) throw new Exception("over length");
            } else {
                if (total > Integer.MAX_VALUE) throw new Exception("over length");
            }

            total = (long) (total + number * Math.pow(10, nums.length - j));
            j++;
        }
        // 正常情况

        return (int)(negative ? -total : total);
    }

    private static int translateToSingleNum(char ch) {
        return ch - '0';
    }
}
