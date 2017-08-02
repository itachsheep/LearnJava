package com.leetcode;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.rmi.CORBA.Util;

import structe_data.Utils;

/**
 * Created by taow on 2017/7/27.
 */

public class Atoi_8 {
    public static void main(String[] args){
//        String s1 = "2147483648";
//        Utils.log("s1 ---------- "+myAtoi(s1));

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        TimeZone china = TimeZone.getTimeZone("GMT+:08:00");
        formatter.setTimeZone(china);

        int adtime = 0;
        String aDduration = formatter.format(adtime);
        Utils.log("adDuration ----------- "+aDduration);
    }
    public static int myAtoi(String str) {
        /**
         * 1, 空格开头
         * 2, 符号+/-
         * 3, 字符串中有字母 --- 0
         */
        if(str == null || str.equals("")){
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
            if(c < '0' || c > '9'){
                break;
            }
            sum = sum * 10 + c - '0';
        }
        sum *= sign;
        if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
            return 0;
        }
        return sum;
    }
}
