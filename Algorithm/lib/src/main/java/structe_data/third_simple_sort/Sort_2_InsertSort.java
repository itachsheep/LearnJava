package structe_data.third_simple_sort;

import java.util.Random;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 14:39
 * Algorithm
 * structe_data
 */

public class Sort_2_InsertSort {
    public static void main(String[] args){
        Random r = new Random();
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(100);
        }

        Utils.printArr(arr);
        insertSort(arr);
        Utils.printArr(arr);
    }

    public static void insertSort(int[] nums){
        /**
         * 插入排序第一趟最多比较一次，第二趟最多比较二次，
         * 最终最多次数 1+2+3.....+N-1 = N*(N-1)/2
         * 实际平均值 ： N*(N-1)/4
         * 移动复制次数大致等于比较次数，但是移动速度快于交换位置
         * 比冒泡快一倍，略快于选择排序
         */
        int n = nums.length;
        int count = 0;
        for(int out = 1; out < n; out++){
            int in = out;
            int temp = nums[out];
            while (in > 0 && nums[in - 1] > temp){
                nums[in] = nums[in - 1];
                in--;
            }
            nums[in] = temp;
        }
    }
}
