package com.tencent;

public class _31_x的N次方最优解 {
    public static void main(String[] args) {
        System.out.println(myPow(2.000,10));
        System.out.println(myPow(2.100,3));
        System.out.println(myPow(2.000,-2));
    }

    /**
     * 这道题还有迭代的解法，让i初始化为n，然后看i是否是2的倍数，
     * 不是的话就让 res 乘以x。然后x乘以自己，
     * i每次循环缩小一半，直到为0停止循环。
     * 最后看n的正负，如果为负，返回其倒数，参见代码如下：
     *
     * https://www.cnblogs.com/grandyang/p/4383775.html
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x,int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if(i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n > 0 ? res : 1/res;
    }
}
