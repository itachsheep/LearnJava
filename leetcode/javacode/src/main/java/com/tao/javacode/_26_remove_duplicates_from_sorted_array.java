package com.tao.javacode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
 * and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place
 with O(1) extra memory.

 Example 1:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

 It doesn't matter what you leave beyond the returned length.
 *
 * Created by SDT14324 on 2018/4/14.
 */

public class _26_remove_duplicates_from_sorted_array {
    public static void main(String[] args){
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }

    public static  int removeDuplicates(int[] nums) {
        int i = 0;
        if(nums.length == 0) return 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
