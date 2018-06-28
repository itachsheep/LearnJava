package com.tao.javacode_part2;

/**
 * Created by taowei on 2018/6/28.
 * 2018-06-28 08:15
 * leetcode
 * com.tao.javacode_part2
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k,
 * return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class _77_combinations {
    public static void main(String[] args){

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs,new ArrayList<List<Integer>>(),1,n,k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs,List<Integer> comb,int start,int n,int k){
        if(k == 0){
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <=n ; i++){
            comb.add(i);
            combine(combs,comb,i+1,n,k-1);
            comb.remove(comb.size() - 1);
        }
    }

}
