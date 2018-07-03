package com.tao.javacode_part2;

/**
 * Created by taowei on 2018/7/3.
 * 2018-07-03 08:15
 * leetcode
 * com.tao.javacode_part2
 */

public class _81_search_in_rotated_sorted_array {
    public static void main(String[] args){

    }

    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1,mid = -1;
        while (start <= end){
            mid = (start + end) / 2;
            if(nums[mid] == target)return true;

            //假设右边是排好序或者左边是没有排序的
            if(nums[mid]  < nums[end] || nums[mid] < nums[start]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
            //假设左边是排好序的或者右边是没有排序的
            else if(nums[mid] > nums[start] || nums[mid] > nums[end]){
                if(target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            //第三种特殊情况，nums[start] == nums[mid] == nums[end]
            //需要去掉重复的元素
            else {
                end--;
            }
        }
        return false;
    }
}
