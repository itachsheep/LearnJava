package com.tencent;

public class _24_爬楼梯_动态规划 {
    public static void main(String[] args) {
        System.out.println(climbingStairs(3));
        System.out.println(climbingStairs(4));
        System.out.println(climbingStairs(5));
        System.out.println(climbingStairs(30));
        System.out.println(climbingStairs(40));
        System.out.println(climbingStairs(50));
        System.out.println(climbingStairs(60));
    }

    public static long climbingStairs(int n) {
        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }
}
