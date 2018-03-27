package com.tao.javacode;

import java.util.Arrays;

/**
 *
 * Given an array S of n integers, find three integers in S
 * such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Created by SDT14324 on 2018/3/27.
 */

public class _16_3Sum_closest {
    public static void main(String[] args){
        int[] s = {-1, 2, 1, -4};
        int target = 1;
        System.out.println("target = "+threeSumClosest(s,target));
    }

    /**
     *
     *首先将数组排序，假设以第一个数i的位置不动，分别移动i+1，和 length -1位置的数，
     * 比较他们的和是否最接近target，然后，i的位置从0到length -3依次变化。
     * 大概需要时间复杂度O(n*n)
     */
    public static int threeSumClosest(int[] num, int target){
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for(int i = 0; i < num.length -2; i++){
            int start = i+1 , end = num.length - 1;
            while (start < end ){
                int sum = num[i] + num[start] + num[end];
                if(sum > target) end--;
                else start++;
                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }
}
