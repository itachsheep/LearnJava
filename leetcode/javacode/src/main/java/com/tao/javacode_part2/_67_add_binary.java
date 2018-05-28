package com.tao.javacode_part2;

/**
 *
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 * Created by SDT14324 on 2018/5/28.
 */

public class _67_add_binary {
    public static void main(String[] args){
        System.out.println(addBinary("11","1"));
        System.out.println(addBinary("1010","1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1 , j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0){
            int sum = carry;
            if(j >= 0) sum += b.charAt(j--) - '0';
            if(i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
