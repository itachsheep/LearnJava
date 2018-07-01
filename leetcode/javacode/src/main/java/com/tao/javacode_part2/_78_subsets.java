package com.tao.javacode_part2;

/**
 * Created by taowei on 2018/7/1.
 * 2018-07-01 09:57
 * leetcode
 * com.tao.javacode_part2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class _78_subsets {
    public static void main(String[] args){
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3,4});
        printlist(subsets);
    }


    public static void printlist(List<List<Integer>> list){
        for (int i = 0; i < list.size(); i++){
            List<Integer> list1 = list.get(i);
            System.out.println(list1);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<Integer>(),nums,0);
        return list;
    }

    /**
     * 先将1 2 3 4 加入templist ，现在有四个元素
     *
     *
     */
    public static void backtrack(List<List<Integer>> list,List<Integer> templist,
                                 int[] nums,int start){
        list.add(new ArrayList<Integer>(templist));//将templist保存起来
        for (int i = start; i < nums.length; i++){
            templist.add(nums[i]);//templist负责将遍历的元素加进来，组成新的list
            //新的list会加入总的list中，
            System.out.println("add i = "+i+", e = "+nums[i]);
            backtrack(list,templist,nums,i+1);
            //当templist将所有的元素都遍历加过了一遍，然后
            Integer remove = templist.remove(templist.size() - 1);
            System.out.println("remove i = "+i+", e = "+remove);
        }
    }
}
