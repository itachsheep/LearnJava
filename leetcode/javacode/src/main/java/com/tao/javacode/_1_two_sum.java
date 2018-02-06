package com.tao.javacode;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class _1_two_sum {

    public static void main(String[] args){
        int[] array = {2,45,32,465,56,32,78,1,83,12,17};
        int target = 90;
        int[] result = two_sum(array,target);
        System.out.println(result[0]+" = "+array[result[0]]+", "+result[1]+
        " = "+array[result[1]]);
    }

    private static int[] two_sum(int[] array, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            int sub = target - array[i];
            if(map.containsKey(sub)){
                int indice = map.get(sub);
                return new int[]{indice,i};
            }
            map.put(array[i],i);
        }
        throw new IllegalArgumentException("no such two numbers");

    }

}
