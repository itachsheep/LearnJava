package hu;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 16:22
 * Algorithm
 * hu
 */

public class Revese_Integer_15 {
    public static void main(String[] args){
        Utils.log("1234567 ---------- "+revers_integer(123456789));
    }

    private static int revers_integer(int n){
        int nRever = 0;
        while (n > 0){
            int temp =  nRever * 10 + (n % 10);
            if(temp - n % 10 != nRever * 10){
                return -1;
            }
            nRever = temp;
            n = n / 10;
        }
        return nRever;
    }
}
