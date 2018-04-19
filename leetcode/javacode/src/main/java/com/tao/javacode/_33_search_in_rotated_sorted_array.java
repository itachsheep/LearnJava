package com.tao.javacode;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 * Created by SDT14324 on 2018/4/18.
 */

public class _33_search_in_rotated_sorted_array {
    public static void main(String[] args){
        System.out.println("index = "+search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println("index = "+search(new int[]{4,5,6,7,0,1,2},3));
    }
    public static int search(int[] a, int target) {
        int lo = 0;
        int hi = a.length -1;
        while (lo < hi){
            int mid = (lo + hi) / 2;
            if(a[mid] == target) return mid;
            if(a[lo] <= a[mid]){
                // 4 5 0 8 12 23 34 45 67
                if(target >= a[lo] && target < a[mid]){
                    hi = mid -1;
                }else {
                    lo = mid + 1;
                }
            }else {
                // 7 8 9 0 1 2 3 4 5 6
                if(target > a[mid] && target <= a[hi]){
                    lo = mid + 1;
                }else {
                    hi = mid -1;
                }
            }
        }
        return a[lo] == target ? lo : -1;
    }
}
