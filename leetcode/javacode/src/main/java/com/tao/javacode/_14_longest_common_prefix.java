package com.tao.javacode;

/**
 *
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 *
 *
 * Created by SDT14324 on 2018/3/24.
 */

public class _14_longest_common_prefix {
    public static void main(String[] args){
        String[] strs = {
                "addfdf",
                "adfdsf",
                "afsdfsdf"
        };
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     *  拿数组第一个字符串第一个字符和其他字符串第一个字符比较
     *  如果都一样，则比较第二个，依次类推
     *  时间复杂度：m * n （m: 数组长度，n:字符串最小长度）
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
