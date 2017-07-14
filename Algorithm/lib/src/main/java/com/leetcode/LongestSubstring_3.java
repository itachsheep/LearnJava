package com.leetcode;

import java.util.HashMap;

/**
 * Created by taowei on 2017/7/14.
 * 2017-07-14 10:35
 * Algorithm
 * com.leetcode
 */

public class LongestSubstring_3 {
    public static void main(String[] args){
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";


        System.out.println("s1 ------------------- "+ lengthOfLongestSubstring(s1));
        System.out.println("s2 ------------------- "+ lengthOfLongestSubstring(s2));
        System.out.println("s3 ------------------- "+ lengthOfLongestSubstring(s3));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int lenMax = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.remove(c);
            }
            map.put(c,i);
            if(map.size() > lenMax){
                lenMax = map.size();
            }
        }

        return lenMax;
    }
}
