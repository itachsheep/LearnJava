package com.tao.javacode_part2;

/**
 * Created by taowei on 2018/6/24.
 * 2018-06-24 10:36
 * leetcode
 * com.tao.javacode_part2
 */

public class _75_color_classification {
    public static void main(String[] args){

        printArray(sortColors(new int[]{2,0,2,1,1,0}));
    }
    public static int[] sortColors(int[] nums) {
        // //时间复杂度：O（n）空间复杂度:O（1）[只遍历一遍完成题目的要求]
        int index0 = -1, index2 = nums.length;

        for (int i = 0; i < nums.length; ){
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 2){
                swap(nums,i,--index2);
            }else if (nums[i] == 0){
                swap(nums,i,++index0);
                i++;
            }else {
                System.out.println("数组有误！！");
            }
            System.out.print("i = "+i+",index0 = "+index0
            +", index2 = "+index2+" ----> ");
            printArray(nums);

        }

        return nums;
    }

    public static void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void printArray(int[] nums){
        for (int i = 0 ; i < nums.length;i++ ){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
