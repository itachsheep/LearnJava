package com.tao.javacode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:

 Input: [1,1,2]
 Output:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 * Created by SDT14324 on 2018/5/10.
 */

public class _47_permutation_2 {
    public static void main(String[] args){
        print(permuteUnique(new int[]{1,1,3}));
    }

    public static void print(List<List<Integer>> list){
        for(int i = 0 ; i < list.size(); i++){
            List<Integer> temp = list.get(i);
            System.out.println(temp.toString());
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),nums,new boolean[nums.length]);
        return list;
    }

    public static void backtrack(List<List<Integer>> list,List<Integer> templist,int[] nums,boolean[] used){
        if(templist.size() == nums.length){
            list.add(new ArrayList<Integer>(templist));
        }else {
            for (int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                templist.add(nums[i]);
                backtrack(list,templist,nums,used);
                used[i] = false;
                templist.remove(templist.size() - 1);
            }
        }
    }
}
