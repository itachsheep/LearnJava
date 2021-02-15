/**
 * @ClassName:
 * @Description:
 * @author taowei
 * @version V1.0
 * @Date
 */

package com.网络头条高频题;

import java.util.HashSet;

public class _1_3无重复字符的最长子串 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "abcabcbb";
//        String s2 = "bbbbb";
//        String s3 = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s1));
//        System.out.println(lengthOfLongestSubstring(s2));
//        System.out.println(lengthOfLongestSubstring(s3));
    }

    public static String lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        String res = "";

        while (i < n && j < n) {
            char c = s.charAt(j);
            if(!set.contains(c)) {
                set.add(c);
                j++;
                System.out.println("add ---------- j: " + j + ",c: " + c);
                if(j - i + 1 > res.length()) {
                    res = s.substring(i,j);
                }
            } else {
                System.out.println("remove i:" + i + " ->  " + s.charAt(i));
                set.remove(s.charAt(i));
                i++;
            }
        }

        return res;
    }
}
