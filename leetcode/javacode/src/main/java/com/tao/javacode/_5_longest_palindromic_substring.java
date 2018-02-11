package com.tao.javacode;

/**
 * Created by SDT14324 on 2018/2/9.
 */

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.


 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class _5_longest_palindromic_substring {
    public static void main(String[] args){
        String s1 = "babad";
        System.out.println("s1 plaindromic substirng = "+longestPalindrome(s1));

        String s2 = "sdfrerfgrgdwrersfwedggytrrwe";
        System.out.println("s2 plaindromic substirng = "+longestPalindrome(s2));

        String s3 = "abacdfgdcaba";
        System.out.println("s3 plaindromic substirng = "+longestPalindrome(s3));
    }

    private static String longestPalindrome(String s){
        int len1 = 0, len2 = 0, len = 0, start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            len1 = expandAroundCenter(s,i,i);
            len2 = expandAroundCenter(s,i,i+1);
            len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len -1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end+1);

    }

    private static int expandAroundCenter(String s,int left,int right){

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }
}
