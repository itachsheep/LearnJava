package hu;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 16:01
 * Algorithm
 * hu
 */

public class Rotate_String_7 {
    public static void main(String[] args){
        /**
         * 要求：

         给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
         样例
         对于字符串 "abcdefg".
         offset=0 => "abcdefg"
         offset=1 => "gabcdef"
         offset=2 => "fgabcde"
         offset=3 => "efgabcd"
         思路：
         假设字符串由XY两部分组成,定义X翻转后为X^T，Y翻转为Y^T，那么可得(X^TY^T)^T=YX字符串成功旋转
         解法二：
         假设原数组序列为abcd1234，要求变换成的数组序列为1234abcd，即循环右移了4位。比较之后，不难看出，其中有两段的顺序是不变的：1234和abcd，可把这两段看成两个整体。右移K位的过程就是把数组的两部分交换一下。
         变换的过程通过以下步骤完成：
         逆序排列abcd：abcd1234 → dcba1234；
         逆序排列1234：dcba1234 → dcba4321；
         全部逆序：dcba4321 → 1234abcd。


         */
        char[] str = "abcdefg".toCharArray();
        rotateString(str,str.length,4);
        Utils.printArr(str);
    }
    private static void rotateString(char[] str,int n,int m){

        //翻转前m个
        reverseString(str,0,m-1);
        //翻转后n-m个
        reverseString(str,m,n-1);
        //整个翻转
        reverseString(str,0,n-1);
    }

    private static void reverseString(char[] s,int start,int end){
        while (start < end){
            char c = s[start];
            s[start++] = s[end];
            s[end--] = c;
        }
    }

    private static void rotate_shift(String s,int m){

    }
}
