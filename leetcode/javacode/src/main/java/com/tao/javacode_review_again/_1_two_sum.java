package com.tao.javacode_review_again;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class _1_two_sum {
    /**
     * 一般来说，我们为了提高时间的复杂度，需要用空间来换，
     * 这算是一个trade off吧，我们只想用线性的时间复杂度来解决问题，
     * 那么就是说只能遍历一个数字，那么另一个数字呢，我们可以事先将其存储起来，
     * 使用一个HashMap，来建立数字和其坐标位置之间的映射，
     * 我们都知道HashMap是常数级的查找效率，这样，我们在遍历数组的时候，
     * 用target减去遍历到的数字，就是另一个需要的数字了，
     * 直接在HashMap中查找其是否存在即可，注意要判断查找到的数字不是第一个数字，
     * 比如target是4，遍历到了一个2，那么另外一个2不能是之前那个2，
     * 整个实现步骤为：先遍历一遍数组，建立HashMap映射，然后再遍历一遍，
     * 开始查找，找到则记录index。
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) return null;
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i  = 0; i < nums.length; i++){
            int sub = target - nums[i];
            if(map.containsKey(sub)){
                int j = map.get(sub);
                return new int[]{i,j};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("not found any nums");
    }
}
