package com.tao.javacode;

/**
 * Created by SDT14324 on 2018/4/16.
 */

public class _31_next_permutation {

    public static void main(String[] args){
//        int[] nums = new int[]{3,2,6,7,1,2,3,4,5};
//        int[] nums = new int[]{1,2,1,0};
        int[] nums = new int[]{3,2,1,5,4,3,2,1};
        printNums(nums);
        nextPermutation(nums);
        printNums(nums);
    }
    public static void printNums(int[] nums){
        for (int i = 0 ; i < nums.length; i++){
            System.out.print(nums[i]+",");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        System.out.println("i = "+i+" -> "+nums[i]);
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            System.out.println("j = "+j+" -> "+nums[j]);
            swap(nums, i, j);
            printNums(nums);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private  static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
