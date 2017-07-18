package com.leetcode;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 10:09
 * Algorithm
 * com.leetcode
 */

public class ZigZagConvr_6 {
    public static void main(String[] args){
        String s1 = "PAYPALISHIRING";
        System.out.println("----------- "+convert(s1,3));
    }

    public static String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
