package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by taowei on 2017/7/14.
 * 2017-07-14 10:35
 * Algorithm
 * com.leetcode
 */

public class Longest_no_repead_Substring_3 {
    public static void main(String[] args){
        String s1 = "abcafdeg";
        String s2 = "bbbbb";
        String s3 = "pwwkew";


        System.out.println("s1 ------------------- "+ lengthOfLongestSubstring(s1));
        System.out.println("s2 ------------------- "+ lengthOfLongestSubstring(s2));
        System.out.println("s3 ------------------- "+ lengthOfLongestSubstring(s3));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;
        int n = s.length();
        /**
         * 滑动窗口从左往右移动，若右边界左边待加入的元素，窗口中没有，则加入，
         * 若窗口中有，则窗口左边界，往右缩小，直至去掉左边界待加入的元素。
         */
        while (i < n && j < n){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                ans = Math.max(ans,i - j);
            }else {
                set.remove(s.charAt(j++));
            }
        }
        return ans;
    }
}
