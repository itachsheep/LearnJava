package com.tao.javacode;

import java.util.Stack;

/**
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Created by SDT14324 on 2018/3/31.
 */

public class _20_Valid_Parentheses {
    public static void main(String[] args){
        String s1 = "()[]{}";
        String s2 = "()[]{}(";
        System.out.println("s1 isValid = "+isValid(s1));
        System.out.println("s2 isValid = "+isValid(s2));

    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            }
            else if(c == '['){
                stack.push(']');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
