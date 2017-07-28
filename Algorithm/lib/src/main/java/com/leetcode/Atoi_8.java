package com.leetcode;

import structe_data.Utils;

/**
 * Created by taow on 2017/7/27.
 */

public class Atoi_8 {
    public static void main(String[] args){
        String s1 = "8781";
        Utils.log("s1 ---------- "+myAtoi(s1));
    }
    public static int myAtoi(String str) {
        /**
         * 1, 空格开头
         * 2, 符号+/-
         * 3, 字符串中有字母 --- 0
         */
        if(str == null || str == ""){
            return 0;
        }
        int index = 0,sign = 1,sum = 0;
        while (str.charAt(index) == ' '){
            index++;
        }
        if(str.charAt(index) == '-'){
            sign = -1;
            index++;
        }else if(str.charAt(index) == '+'){
            sign = 1;
            index++;
        }
        for(; index < str.length(); index++){
            char c = str.charAt(index);
            if(c > '0' || c < '9'){
                return 0;
            }
            sum = sum * 10 + c - '0';
        }

        return sum;
    }
}
