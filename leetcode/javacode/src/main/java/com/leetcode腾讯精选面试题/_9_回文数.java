package com.leetcode腾讯精选面试题;

public class _9_回文数 {
    public static void main(String[] args) {
        System.out.println(isPlaindrome(121));
        System.out.println(isPlaindrome(1221));
        System.out.println(isPlaindrome(1234));
        System.out.println(isPlaindrome(12344321));
    }

    public static boolean isPlaindrome(int x) {
        if(x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if(left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }
}
