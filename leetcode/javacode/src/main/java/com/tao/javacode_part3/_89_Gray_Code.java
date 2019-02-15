package com.tao.javacode_part3;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 格雷码是一个二进制数字系统，其中两个连续的值只相差一位。
 * 给定一个非负整数n表示代码中比特的总数，打印格雷码的序列。格雷码序列必须以0开头
 */
public class _89_Gray_Code {
    public static void main(String[] args){

    }

    /**
     *
     *仔细观察格雷码
     * 当n=1时
     *
     * 1
     * 0
     * 当n=2时
     *
     * 00
     * 01
     * 11
     * 10
     * 当n=3时
     *
     * 000
     * 001
     * 011
     * 010
     * 110
     * 111
     * 101
     * 100
     * 可以发现，n的格雷码，就是n-1的格雷码，再加上它们的逆序前面多一个1。
     *
     * 复杂度
     * 时间 O(N) 空间 O(N)
     *
     * 思路
     * 工业中的第i个格雷码是这么生成的：(i>>1)^i
     * i是指下标，从0开始，对于n的格雷码序列，一共有2^n个数
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++){
            res.add((i >> 1)^ i);
        }
        return res;
    }
}
