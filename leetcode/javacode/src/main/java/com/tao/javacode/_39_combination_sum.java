package com.tao.javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 * Created by SDT14324 on 2018/4/24.
 */

public class _39_combination_sum {
    public static void main(String[] args){
        List<List<Integer>> res = combinationSum(new int[]{2,3,5},8);
        printList(res);
    }

    public static void printList(List<List<Integer>> list){
        if(null == list) return;
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, target, 0);
        return list;
    }
   /* public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list,new ArrayList<Integer>(),nums,target,0);
        return list;
    }*/

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                System.out.println("templist = "+tempList.toString());
                //类似深度优先遍历
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

   /* public static void backTrack(List<List<Integer>> list,List<Integer> tempList,int[] nums,
                                 int remain,int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<Integer>());
        else {
            for(int i = start; i < nums.length ; i++){
                tempList.add(nums[i]);
                backTrack(list,tempList,nums,remain - nums[i],i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }*/
}
