package com.tao.javacode;

/**
 *
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1

 * Created by SDT14324 on 2018/4/14.
 */

public class _28_Implement_strStr {
    public static void main(String[] args){
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","bba"));
        System.out.println(strStr("aaaaa","aa"));
    }
    public static int strStr(String haystack,String needle){
        for(int i = 0;; i++){
            for(int j = 0;;j++){
                if(j == needle.length()) return  i;
                if(i == haystack.length()) return -1;
                if(needle.charAt(j) != haystack.charAt(i)) break;
            }
        }
    }
}
