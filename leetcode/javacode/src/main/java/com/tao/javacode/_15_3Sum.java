package com.tao.javacode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c in S such
 that a + b + c = 0? Find all unique triplets in the array which gives
 the sum of zero.

 Note: The solution set must not contain duplicate triplets.
 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 *
 *
 * Created by taowei on 2018/3/25.
 * 2018-03-25 11:08
 * leetcode
 * com.tao.javacode
 */

public class _15_3Sum {
    public static void main(String[] args){
        int[] s = {-1, 0, 1, 2, -1, -4};
        LinkedList<List<Integer>> res = threeSum(s);
        System.out.println("res size = "+res.size());
        printList(res);

    }

    /**
     *  首先将数列进行排序，从小到大，
     *  从第一个数开始遍历，将第二个数和最后一个数相加，是否等于 sum = 0 - 第一个数
     *  如果第二个数与最后一个数的和，大于sum，则需要从数列中较小的数中找
     *  反之，从数列中较大的数列中找
     *
     * @param num
     * @return
     */
    private static LinkedList<List<Integer>> threeSum(int[] num){
        Arrays.sort(num);
        LinkedList<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < num.length -2 ; i++){
            if(i == 0 || (i > 0 && num[i] != num[i-1])){
                int lo = i + 1;
                int hi = num.length - 1;
                int sum = 0 - num[i];
                while (lo  < hi){
                    if(num[lo] + num[hi] == sum){
                        res.add(Arrays.asList(num[i],num[lo],num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if(num[lo] + num[hi] < sum){
                        //如果两个数之和小于sum，则需要从数列中找大一点的
                        lo++;
                    }
                    else {
                        //如果两个数之和大于sum，则需要从数列中找小一点的
                        hi--;
                    }
                }
            }
        }

        return res;
    }

    private static void printList(LinkedList<List<Integer>> res){
        for(int i = 0; i < res.size(); i++){
            List<Integer> list = res.get(i);
            for(int j = 0; j < list.size(); j++){
                System.out.print(list.get(j)+" -> ");
            }
            System.out.println();
        }
    }
}
