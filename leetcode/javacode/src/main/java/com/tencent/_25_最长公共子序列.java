package com.tencent;

public class _25_最长公共子序列 {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int lcs = lcs(ch1, ch2, ch1.length, ch2.length);
        System.out.println("lcs: " + lcs + ", " + sb.toString());
    }

    /**
     * https://blog.csdn.net/Bryan__/article/details/51927537
     *  最长公共子序列:
     * 这是一个动态规划问题
     * 当其中一个串长度为0的时候子序列为0
     * 当两个串尾字符相等时，最长子序列等于子串的最长子序列长度+1
     * 当尾字符不等时，等于两个串的子串最大的最长子序列长度
     *
     * 代码参考：
     * https://blog.csdn.net/seagal890/article/details/89602682
     *
     */
    public static int lcs(char[] ch1,char[] ch2,int m,int n) {
        if(m == 0 || n == 0) {
            return 0;
        }

        if(ch1[m-1] == ch2[n-1]) {
            return 1 + lcs(ch1,ch2,m-1,n-1);
        } else {
            return Math.max(lcs(ch1,ch2,m-1,n),lcs(ch1,ch2,m,n-1));
        }
    }
}
