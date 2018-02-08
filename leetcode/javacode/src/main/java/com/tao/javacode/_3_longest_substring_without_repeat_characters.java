package com.tao.javacode;

/**
 * Created by SDT14324 on 2018/2/7.
 */

import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class _3_longest_substring_without_repeat_characters {
    public static void main(String[] args){

        String str = "pwwkew";
        //String str = "abcabcbb";
        System.out.println("str longest substring = "+lengthOfLongestSubstring(str));
    }

    private static String lengthOfLongestSubstring(String s){
        int n = s.length();
        String lgStr = "";
        HashSet<Character> set = new HashSet<>();
        int i = 0,j = 0;
        while (i < n && j < n ){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                j++;
                if(j - i+1 > lgStr.length()){
                    lgStr = s.substring(i,j);
                }
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return lgStr;
    }
}
