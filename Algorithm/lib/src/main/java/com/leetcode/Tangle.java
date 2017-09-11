package com.leetcode;

/**
 * Created by SDT14324 on 2017/9/6.
 */

public class Tangle {
    public static void main(String[] args){

        double angle = 180;
        double radians = Math.toRadians(angle);
        System.out.println("angle: "+angle+", radians: "+radians
                +", res: "+Math.sin(radians)/Math.cos(radians)+", tan: "+Math.tan(radians));
    }
}
