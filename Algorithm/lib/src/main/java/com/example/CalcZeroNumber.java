package com.example;

/**
 * Created by taowei on 2017/7/11.
 * 2017-07-11 22:19
 * Algorithm
 * com.example
 */

public class CalcZeroNumber {
    public static void main(String[] args){
        System.out.println("5! ----- "+zeroNumer(5)+", 5! = "+multiNumber(5));
        System.out.println("6! ----- "+zeroNumer(6)+", 6! = "+multiNumber(6));
        System.out.println("7! ----- "+zeroNumer(7)+", 7! = "+multiNumber(7));
        System.out.println("10! ----- "+zeroNumer(10)+", 10! = "+multiNumber(10));
        System.out.println("15! ----- "+zeroNumer(15)+", 15! = "+multiNumber(15));
    }

    private static long multiNumber(int n) {
        long res = 1;
        for (int i = 1 ; i <= n; i++){
            res = res * i;
        }
        return res;
    }

    private static int zeroNumer(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++){
            int t = i;
            while (t % 5 == 0){
                System.out.println("i------------"+i+", count = "+count);
                count++;
                t = t / 5;
            }
        }
        return count;
    }
}
