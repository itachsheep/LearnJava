package com.tao.javacode;

/**
 *
 * Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 * Created by SDT14324 on 2018/4/28.
 */

public class _41_first_missing_positive_integer {

    public static void main(String[] args){
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }
    public static int firstMissingPositive(int[] nums) {
        int expectedNum = 1;
        int missingNum = expectedNum;
        while (missingNum == expectedNum){
            for(int i = 0; i< nums.length; i++){
                if(nums[i] < 0) continue;
                if(nums[i] != expectedNum) continue;
                expectedNum++;
            }
            if(missingNum == expectedNum) break;
            missingNum = expectedNum;
        }
        return expectedNum;
    }

}
