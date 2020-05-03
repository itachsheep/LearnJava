package com.tao.javacode;

/**
 * Created by SDT14324 on 2018/2/13.
 */


/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge,
 please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 You are responsible to gather all the input requirements up front.
 */
public class _8_string_to_integer {
    public static void main(String[] args){
        System.out.println("   21232324376767676 = "+myAtoi("  2123232437"));
        //System.out.println('2' - '0');
    }
    public static int myAtoi(String str) {
        int multi = 1,sum = 0,temp = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '-'){
                multi = -1;
            }

            if(c >= '0' && c <= '9'){
                if(multi > 0){
                    temp = sum * 10 + c - '0';
                    if(temp < 0){
                        throw new IllegalArgumentException("number is too large!!");
                    }
                    sum = temp;
                } else {
                    temp =  sum * 10 - (c - '0');
                    if(temp > 0){
                        throw new IllegalArgumentException("number is too small!!");
                    }
                    sum = temp;
                }
            }

        }
        return sum;
    }
}
