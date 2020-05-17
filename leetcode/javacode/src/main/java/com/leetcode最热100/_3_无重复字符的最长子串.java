package com.leetcode最热100;

import java.util.HashSet;
import java.util.Set;

public class _3_无重复字符的最长子串 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(lengthOfLongestSubString(s1));
        System.out.println(lengthOfLongestSubString(s2));
        System.out.println(lengthOfLongestSubString(s3));
    }

    /**
     * 1，使用滑动窗口，以第 left 数为起点，不断往set中添加新的元素，
     * 2，添加到第 rk 个元素，滑动窗口变大，记录当前size = rk - left + 1, 与最大max比较，
     * 3，当遇到第一个重复字符，删除之前的，滑动窗口变小。
     */
    public static int lengthOfLongestSubString(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = 1, max = 0;
        set.add(s.charAt(0));

        for (int left = 1; left < n; left++) {
            while (rk < n && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                ++rk;
            }
            max = Math.max(max, rk - left + 1);
            set.remove(s.charAt(left -1));
        }
        return max;
    }
}
