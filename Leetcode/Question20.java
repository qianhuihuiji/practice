package Leetcode;

import java.util.Stack;

public class Question20 {
    public static void main(String[] args) {
        String test = "()[]{}";
        System.out.println(isValid(test));
    }

    private static boolean isValid(String s) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 0;i < s.length();i++) {
            String  ch = s.substring(i,i+1);
            String match = getMatch(ch);
            if (match.isEmpty()) {
                stringStack.push(ch);
            } else {
                if (! stringStack.empty() && stringStack.peek().equals(match)) {
                    stringStack.pop();
                }else {
                    return false;
                }
            }
        }

        return stringStack.isEmpty();
    }

    private static String getMatch(String s) {
        switch (s) {
            case ")" : return "(";
            case "]" : return "[";
            case "}" : return "{";
            default : return "";
        }
    }
}