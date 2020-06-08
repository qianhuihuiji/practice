package Leetcode;

public class Question13 {
    public static void main(String[] args) {
        String test = "MDCXCV";
        System.out.println(romanToInt(test));
    }

    private static int romanToInt(String s) {
        int ans = 0;
        int preNum = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                ans -= preNum;
            }else {
                ans += preNum;
            }

            preNum = num;
        }

        ans += preNum;

        return ans;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}