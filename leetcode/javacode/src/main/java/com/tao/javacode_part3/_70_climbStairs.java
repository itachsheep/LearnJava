package com.tao.javacode_part3;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 *   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 * 一共有N阶梯子，每次只能爬1阶或者2阶，问爬到N阶时，可以有多少方式？
 * 可以这样思考，爬到N阶，可以从第N-1阶爬1步，也可以从第N-2阶爬2步。
 * 也就是说到N阶的方式有f(N-1)+f(N-2)种方式（因为要么1步，要么2步），
 * 后面一次类推。可以看出这是个菲波那切数列
 */
public class _70_climbStairs {
    public int climbStairs(int n){
        if(n == 1)return 1;
        if(n == 2)return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
