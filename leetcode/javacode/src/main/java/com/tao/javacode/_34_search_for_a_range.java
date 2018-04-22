package com.tao.javacode;

/**
 *
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 * Created by SDT14324 on 2018/4/22.
 */

public class _34_search_for_a_range {
    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        printNums(searchRange(nums,8));
    }

    private static int extremeInsertionIndex(int[] nums,int target,boolean left){
        int lo = 0;
        int hi = nums.length -1;
        while (lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > target || (left && target == nums[mid])){
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        //找到target最左边坐标
        int leftIdx = extremeInsertionIndex(nums,target,true);
        if(leftIdx == nums.length || nums[leftIdx] != target){
            return range;
        }
        range[0] = leftIdx;
        //找到target最右边坐标
        range[1] = extremeInsertionIndex(nums,target,false) - 1;

        return range;

    }
    public static void printNums(int[] nums){
        for (int i = 0 ; i < nums.length; i++){
            System.out.print(nums[i]+",");
        }
        System.out.println();
    }
}
