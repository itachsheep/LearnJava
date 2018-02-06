package com.leetcode;

import java.util.HashMap;

/**
 * Created by taowei on 2017/7/13.
 * 2017-07-13 20:17
 * Algorithm
 * com.example
 */

public class TwoSum_1 {
    public static void main(String[] args){
        /**
         * Example:
            Given nums = [2, 7, 11, 15], target = 9,

            Because nums[0] + nums[1] = 2 + 7 = 9,
            return [0, 1].
         */

        int[] nums = {2, 7, 11, 15};
        int target = 26;
        int[] res = twoSum(nums, target);
        System.out.println("res[] :  "+res[0]+", "+res[1]);
        System.out.println();
    }



    public static int[] twoSum(int[] nums, int target) {
        /**
         *  方式一强力破解
         int[] res = new int[2];
        for(int i = 0; i < nums.length - 1; i++){
            int j  = i+1;
            for( ;j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    System.out.println("-------------find ---------------: "+i+", "+j);
                }
            }
        }
        return res;*/

        /**
         *  双程-hashtable
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i++){
            int num2 = target - nums[i];
            if(map.containsKey(num2) && map.get(num2) != i){
                int j = map.get(num2);
                System.out.println("-------------find ---------------: "+i+", "+j);
                return new int[]{i,j};
            }
        }
        throw new IllegalArgumentException("No two soulution..");*/


        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int component = target - nums[i];
            if(map.containsKey(component)){
                int j = map.get(component);
                System.out.println("-------------find ---------------: "+i+", "+j);
                return new int[]{i,j};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two solution..");
    }
}
