package hu;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 10:55
 * Algorithm
 * hu
 */

public class Frog_step_3 {
    public static void main(String[] args){
        /**
         * 一只青蛙可以一次跳一级台阶，也可以一次跳两级台阶
         * ，如果青蛙要跳上n级台阶，共有多少钟跳法？
         */
        Utils.log("1 ---------- "+fibnocacci(1));
        Utils.log("2 ---------- "+fibnocacci(2));
        Utils.log("3 ---------- "+fibnocacci(3));
        Utils.log("4 ---------- "+fibnocacci(4));
        Utils.log("5 ---------- "+fibnocacci(5));
        Utils.log("6 ---------- "+fibnocacci(6));
        Utils.log("7 ---------- "+fibnocacci(7));
    }

    public static int fibnocacci(int n){
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        return fibnocacci(n-1)+fibnocacci(n-2);
    }
}
