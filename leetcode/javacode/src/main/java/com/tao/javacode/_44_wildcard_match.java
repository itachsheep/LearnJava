package com.tao.javacode;

/**
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "*"
 Output: true
 Explanation: '*' matches any sequence.
 Example 3:

 Input:
 s = "cb"
 p = "?a"
 Output: false
 Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 Example 4:

 Input:
 s = "adceb"
 p = "*a*b"
 Output: true
 Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 Example 5:

 Input:
 s = "acdcb"
 p = "a*c?b"
 Output: false
 * Created by SDT14324 on 2018/5/4.
 */

public class _44_wildcard_match {
    public static void main(String[] args){
//        System.out.println("res = "+isMatch("aa","a"));
//        System.out.println("res = "+isMatch("aa","*"));
//        System.out.println("res = "+isMatch("cb","?a"));
        System.out.println("res = "+isMatch("adceb","*a*b"));
//        System.out.println("res = "+isMatch("acdcb","a*c?b"));
    }

    public static  boolean isMatch(String str, String pattern) {
        int step = 1;
        int s = 0, p = 0, match = 0, starIdx = -1;
        while ( s < str.length()){
            if(p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                System.out.println("if 1 , step "+(step++)+", s = "+str.charAt(s)+", p = "+pattern.charAt(p));
                s++;
                p++;

            }else if(p < pattern.length() && pattern.charAt(p) == '*'){
                System.out.println("if 2 , step "+(step++)+", s = "+str.charAt(s)+", p = "+pattern.charAt(p));
                starIdx = p;
                match = s;
                p++;

            }else if(starIdx != -1){
                System.out.println("if 3 , step "+(step++)+", s = "+str.charAt(s)+", p = "+pattern.charAt(p));
                p = starIdx + 1;
                match++;
                s = match;

            }else {
                System.out.println("if 4 , step "+(step++)+", s = "+str.charAt(s)+", p = "+pattern.charAt(p));
                return false;
            }
        }
        while (p < pattern.length() && pattern.charAt(p) == '*'){
            p++;
        }
        return p == pattern.length();
    }
}
