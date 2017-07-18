package com.leetcode;
import structe_data.Utils;

/**
 * Created by taowei on 2017/7/17.
 * 2017-07-17 16:53
 * Algorithm
 * com.leetcode
 */

public class LongestPalindromic_5 {
    public static void main(String[]args){
        String s1 = "abcda";
        Utils.log("s1 ---- "+longestPalindrome(s1));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;

        for(int i = 0; i < n-1; i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end -start){
                start = i - (len -1) /2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);

    }
    public static int expandAroundCenter(String s,int left,int right){
        int l = left;
        int r = right;
        int n = s.length();

        while(l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            System.out.println("l: "+l+", r: "+r);
        }


        return r-l-1;
    }
    public String my(String s){

        /**
         * 太执着于自己的解题思路，往往适得其反，不如摒弃自己的想法，
         * 直接用最
简单，最完美的解题思路。
         * 任意取一个字符，以之为中心向两边扩展，计算最长的，
         * 时间复杂度O(n^2)
         * 需要分两种情况，一种是 aba,回文奇数
         *               二种是 abba,回文偶数
         */
        int n = s.length();
        int start = -1;
        int maxlen = -1;
        for(int i = 0; i < n ; i++){
            int limit = Math.min(i,n-i-1);
            int j = 1;
            while(j <= limit && s.charAt(i+j) == s.charAt(i-j)){
                if(2*j+1 > maxlen){
                    start = i - j;
                    maxlen = 2*j +1;
                    Utils.log("1---------start : "+start+", maxlen: "+maxlen+",i: "+i+
                            ", j: "+j);
                }
                j++;
            }
        }

        for(int i = 0; i < n; i++){
            int limit2 = Math.min(i,n-i-2);
            int j = 0;
            while(j <= limit2 && s.charAt(i-j) == s.charAt(i+j+1)){
                if(2*j +2> maxlen){
                    start = i - j;
                    maxlen = 2*j + 2;
                    Utils.log("2---------start : "+start+", maxlen: "+maxlen
                            +",i: "+i+",j: "+j);
                }
                j++;
            }
        }
        if(maxlen != -1){
            String res = s.substring(start,start+maxlen);
            Utils.log("res -------- "+res);
            return res;

        }else {
            return s.charAt(0)+"";
        }
    }
}
