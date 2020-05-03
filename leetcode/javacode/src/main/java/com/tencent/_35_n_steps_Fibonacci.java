package com.tencent;

/**
 * n 个台阶问题，斐波那契数列
 * 假设只有一个台阶，那么只有一种跳法，那就是一次跳一级，f(1)=1；
 * 如果有两个台阶，那么有两种跳法，第一种跳法是一次跳一级，第二种跳法是一次跳两级,f(2)=2。
 * 如果有n个台阶，从 n -1 上跳一级上去，或者 从 n-2上 跳两级上去，
 *     所以f(n) = f(n-1) + f(n-2)
 */
public class _35_n_steps_Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibnacci(3));
        System.out.println(fibnacci(4));
        System.out.println(fibnacci(5));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(fibnacci(50));

    }

    public static long fibnacci(int n) {
        if(n < 1) {
            return  0;
        }

        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }
        return fibnacci(n-1) + fibnacci(n-2);
    }
}

