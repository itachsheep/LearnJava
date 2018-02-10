package com.tao.javacode;

/**
 * Created by taowei on 2018/2/10.
 * 2018-02-10 09:12
 * leetcode
 * com.tao.javacode
 */

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output:  321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only hold integers
 within the 32-bit signed integer range. For the purpose of this problem,
 assume that your function returns 0 when the reversed integer overflows.


 */
public class _7_reverse_integer {
    public static void main(String[] args){
        System.out.println("revers 123 = "+reverse(123));
        System.out.println("revers -123 = "+reverse(-123));
        System.out.println("revers 120 = "+reverse(120));
        System.out.println("revers -120 = "+reverse(-120));
    }

    private static int reverse(int x){
        int reverse = 0,temp = 0;
        while (x != 0){
            int mod = x % 10;
            reverse = temp * 10 + mod;
            if((reverse - mod) / 10 != temp){
                //越界了
                return 0;
            }
            temp = reverse;
            x = x / 10;
        }
        return reverse;
    }
}
