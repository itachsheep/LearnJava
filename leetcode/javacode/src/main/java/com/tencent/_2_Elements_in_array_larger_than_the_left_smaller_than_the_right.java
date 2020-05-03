package com.tencent;

import com.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 以时间复杂度O(n)从长度为n的数组中找出同时满足下面两个条件的所有元素：
 * （1）该元素比放在它左边的所有元素都大；
 * （2）该元素比放在它右边的所有元素都小。
 *
 * 输入：一个数组
 *
 * 输出：返回一个数组，数组中保存的是符合条件的元素的下标。
 */
public class _2_Elements_in_array_larger_than_the_left_smaller_than_the_right {

    public static void main(String[] args) {
        Util<Integer> util = new Util<>();
        int[] test1 = {3, 5, 4, 2, 1, 6, 8, 7};
        int[] test2 = {1,2, 3, 4, 5, 6, 7, 8};
        int[] test3 = {1,2,3,1,2,0,5,6};

        util.printArrayList(findElements(test1));
        util.printArrayList(findElements(test2));
        util.printArrayList(findElements(test3));

    }

    public static List<Integer> findElements(int[] nums){
        List<Integer> output = new ArrayList<>();
        int[] rightMins = new int[nums.length];

        int min = Integer.MAX_VALUE;
        for(int i = nums.length -1 ; i >= 0; --i) {
            rightMins[i] = min;
            if(nums[i] < min) {
                min = nums[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j <= nums.length-1; j++){
            if(nums[j] > max) {
                max = nums[j];
                if(nums[j] < rightMins[j]) {
                    output.add(nums[j]);
                }
            }
        }
        return output;
    }

}
