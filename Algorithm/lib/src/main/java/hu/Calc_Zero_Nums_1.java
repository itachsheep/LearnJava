package hu;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 10:26
 * Algorithm
 * hu
 */

public class Calc_Zero_Nums_1 {
    public static void main(String[] args){
        /**
         * 给定一个整数n，求解它的阶乘的乘积里末尾0的个数。
         * 举个例子，比如3! = 1 2 3 = 6,末尾0的个数为0,
         * 5! = 1 2 3 4 5 = 120,末尾0的
         * 6! = 720
         * 7!= 5040
         * 20! = 243xxx640000
         * 25! = 155xxx84000000
         */

        Utils.log("5! ---- "+calc_num(5));
        Utils.log("6! ---- "+calc_num(6));
        Utils.log("7! ---- "+calc_num(7));
        Utils.log("20! ---- "+calc_num(20));
        Utils.log("25! ---- "+calc_num(25));
    }
    public static int calc_num(int n){
        int num = 0;
        for(int i = n; i > 0; i--){
            int j = i;
            while (j % 5 == 0){
                num++;
                j = j / 5;
            }
        }
        return num;
    }

}
