package easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
https://neetcode.io/problems/validate-parentheses
* */
public class ValidateParentheses {

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
//        List<Character> back = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (s.charAt(i)) {
                case '{', '[', '(':
                    stack.push(s.charAt(i));
                break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != '(') {
                        return false;
                    }
            }
        }
        return stack.isEmpty();

    }


    public static void main(String[] args) {
//        String s = "([{}])";
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

}
