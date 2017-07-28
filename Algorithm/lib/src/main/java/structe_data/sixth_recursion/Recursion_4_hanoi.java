package structe_data.sixth_recursion;

import structe_data.Utils;

/**
 * Created by taow on 2017/7/20.
 */

public class Recursion_4_hanoi {
    public static void main(String[] args){
        hanoi(3,'A','B','C');
    }

    private static void hanoi(int n, char from, char inter, char to){
        if(n == 1){
            Utils.log(n+"----------- from "+from+" to ---------"+to);
        }else {
            hanoi(n-1,from,to,inter);
            Utils.log(n+"*********** from "+from+" to *********"+to);
            hanoi(n-1,inter,from,to);
        }
    }
}
