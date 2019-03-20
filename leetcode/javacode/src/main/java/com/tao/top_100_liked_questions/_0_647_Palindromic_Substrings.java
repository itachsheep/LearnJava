package com.tao.top_100_liked_questions;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different
 * substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class _0_647_Palindromic_Substrings {
    /**
     * 其实这道题也可以用递归来做，而且思路非常的简单粗暴。
     * 就是以字符串中的每一个字符都当作回文串中间的位置，
     * 然后向两边扩散，每当成功匹配两个左右两个字符，结果res自增1，
     * 然后再比较下一对。注意回文字符串有奇数和偶数两种形式，
     * 如果是奇数长度，那么i位置就是中间那个字符的位置，
     * 所以我们左右两遍都从i开始遍历；如果是偶数长度的，
     * 那么i是最中间两个字符的左边那个，右边那个就是i+1，
     * 这样就能cover所有的情况啦，而且都是不同的回文子字符串，
     */
    public int countSubstrings(String s) {
        if(s == null) return 0;
        Integer res = new Integer(0);
        for (int i = 0; i < s.length(); i++){
            helper(s,i,i,res);
            helper(s,i,i+1,res);
        }
        return res;
    }
    void helper(String s,int i,int j,Integer res){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            res++;
            --i;
            ++j;
        }
    }
}
