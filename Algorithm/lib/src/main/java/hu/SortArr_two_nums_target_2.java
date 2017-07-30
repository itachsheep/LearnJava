package hu;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/30.
 * 2017-07-30 10:41
 * Algorithm
 * hu
 */

public class SortArr_two_nums_target_2 {
    public static void main(String[] args){
        /**
         * 算法--在给定的有序数组中寻找两个之和为n的两个元素
         */
        int[] a = { 1, 3, 5, 7, 9, 11 };
        int[] nums = find_two_nums_target(a, 8);
        for (int i :
                nums) {
            System.out.print(i+" - "+a[i]+", ");
        }
    }

    public static int[] find_two_nums_target(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;

        while (left < right){
            int cur = arr[left]+arr[right];
            if(cur == target)
                return new int[]{left,right};
            else if(cur < target)
                left++;
            else
                right--;
        }
        throw new IllegalArgumentException("no such nums");
    }
}
