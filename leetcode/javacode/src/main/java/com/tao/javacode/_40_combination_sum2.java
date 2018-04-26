package com.tao.javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.

 Each number in candidates may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [10,1,2,7,6,1,5], target = 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 Example 2:

 Input: candidates = [2,5,2,1,2], target = 5,
 A solution set is:
 [
 [1,2,2],
 [5]
 ]
 * Created by SDT14324 on 2018/4/26.
 */

public class _40_combination_sum2 {
    public static void main(String[] args){
        List<List<Integer>> res = combinationSum2(new int[]{2,3,5},8);
        List<List<Integer>> res1 = combinationSum2(new int[]{10,1,2,7,6,1,5},8);
        List<List<Integer>> res2 = combinationSum2(new int[]{2,5,2,1,2},5);

        printList(res);
        printList(res1);
        printList(res2);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i - 1]) continue;
                tempList.add(nums[i]);
               // System.out.println("templist = "+tempList.toString());
                //类似深度优先遍历
                backtrack(list, tempList, nums, remain - nums[i], i+1); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void printList(List<List<Integer>> list){
        if(null == list) return;
        System.out.println("-----------------------------");
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }
}
