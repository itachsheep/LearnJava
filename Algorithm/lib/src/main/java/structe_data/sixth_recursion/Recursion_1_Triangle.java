package structe_data.sixth_recursion;

/**
 * Created by taowei on 2017/7/19.
 * 2017-07-19 22:29
 * Algorithm
 * structe_data
 */

public class Recursion_1_Triangle {
    public static void main(String[] args){
        for(int i = 1; i < 10; i++){
            System.out.println(i+" ---------- "+triangle(i));
        }
    }

    public static int triangle(int n){
        /**
         * 1  1
         * 3  1+2
         * 6  1+2+3
         * ...
         * n
         */
        if(n == 1) return 1;
        return triangle(n-1)+n;
    }
}
