package com.leetcode;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 13:51
 * Algorithm
 * com.leetcode
 */

public class ReverseInteger_7 {
    /**
     * Reverse digits of an integer.

     Example1: x = 123, return 321
     Example2: x = -123, return -321

     click to show spoilers.

     Note:
     The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

     * @param args
     */
    public static void main(String[] args){

        Utils.log("123 --------- "+(Integer.MIN_VALUE == 0x80000000));
        Utils.log("123 --------- "+(Integer.MAX_VALUE));
        int a = Integer.MAX_VALUE -2;
        int b = 10;
        int c = a+b;
        Utils.log("123 --------- "+(c));

    }
    public static int reverse(int x){
        long result = 0;

        while (x != 0){
//            int tail = x % 10;
//            int newResult = result * 10 +tail;
//            if((newResult - tail)/10 != result){
//                return 0;
//            }
//            result = newResult;
//            x = x /10;
            int tail = x % 10;
            result = result * 10 + tail;
            if(result > 0x7fffffff || result < 0x80000000){
                return 0;
            }

            x = x / 10;
        }
        return (int) result;
    }
}
