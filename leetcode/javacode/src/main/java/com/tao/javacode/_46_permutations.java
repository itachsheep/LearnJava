package com.tao.javacode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 * Created by SDT14324 on 2018/5/7.
 */

public class _46_permutations {
    public static void main(String[] args){
        print(permute(new int[]{1,2,3}));
    }

    public static void print(List<List<Integer>> list){
        for(int i = 0 ; i < list.size(); i++){
            List<Integer> temp = list.get(i);
            System.out.println(temp.toString());
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),nums);
        return list;
    }
    public static void backtrack(List<List<Integer>> list,List<Integer> templist,int[] nums){
        if(templist.size() == nums.length){
            list.add(new ArrayList<Integer>(templist));
        }else {
            for (int i = 0; i < nums.length; i++){
                if(templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                backtrack(list,templist,nums);
                templist.remove(templist.size() - 1);
            }
        }
    }
}
