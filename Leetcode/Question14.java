package Leetcode;

public class Question14 {
    public static void main(String[] args) {
        String[] test = new String[] {"ca","a"};
        System.out.println(longestCommonPrefix(test));
    }

    private static String longestCommonPrefix(String[] strs) {
        int length = strs.length;

        if (length == 0) return "";

        String ans = strs[0];
        for (int i = 1;i < length;i++) {
            if (strs[i].length() < ans.length()) ans = strs[i];
        }

        for (int i = 0;i < length;i++) {
            String word = strs[i];
            int loopSize = ans.length() > word.length() ? word.length() : ans.length();
            for (int j = 0;j < loopSize;j++) {
                if(ans.charAt(j) != word.charAt(j)) {
                    ans = ans.substring(0, j);
                    break;
                }
            }
        }

        return ans;
    }
}