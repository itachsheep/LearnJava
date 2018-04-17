package com.tao.javacode;

import java.util.Stack;

/**
 * Created by SDT14324 on 2018/4/17.
 */

public class _32_longest_valid_parenthese {
    public static void main(String[] args){
//        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(")"));
    }
    public static int longestValidParentheses(String s) {
        int maxlen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                Integer pop = stack.pop();
                System.out.println("pop = "+pop);
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    System.out.println("peek = "+stack.peek());
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }
        return maxlen;
    }
}
