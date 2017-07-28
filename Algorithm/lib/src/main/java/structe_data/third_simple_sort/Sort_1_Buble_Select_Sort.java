package structe_data.third_simple_sort;

import java.util.Random;

import structe_data.Utils;

/**
 * Created by taowei on 2017/7/15.
 * 2017-07-15 17:13
 * Algorithm
 * structe_data
 */

public class Sort_1_Buble_Select_Sort {
    public static void main(String[] args){
        Random r = new Random();
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(100);
        }
        Utils.printArr(arr);
        bubleSort(arr);
        Utils.printArr(arr);

        System.out.println("########################################");

        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(100);
        }
        Utils.printArr(arr);
        selectSort(arr);
        Utils.printArr(arr);
    }

    public static void bubleSort(int[] arr){
        int count_swap = 0;
        /**
         * 两两比较，较大放在后面
         * 第一趟 ： i = 0；0 - arr.length -1
         * 第二趟 ： i = 1；0 - arr.length -1 - i
         * 最坏的情况，交换和比较需的次数，n(n-1),运行时间O(n^2)
         */
        for(int i = 0; i < arr.length; i++){

            for(int j = 0; j < arr.length - 1 -i ;j++){
                if(arr[j] > arr[j+1]){
                    count_swap++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("buble sort swap count --------- "+count_swap);
    }

    public static void selectSort(int[] arr){
        /**
         * 第一趟，将最小的放到最前面 比较次数 i= 0， n - 0
         * 第二趟，将第二小的放在第二个位置，i= 1，比较次数 n - 1;
         *
         * 选择排序改进了冒泡排序，将必要的交换次数从O(N^2)减少到O(N)
         * 但是比较次数仍为O(n^2)
         */
        int min;
        for(int out = 0; out < arr.length - 1; out++){
            min = out;
            for(int in = out+1; in < arr.length; in++){
                if(arr[in] < arr[min]){
                    min = in;
                }
            }
            swap(arr,out,min);
        }
    }

    private static void swap(int[] nums,int out, int min) {
        int temp = nums[out];
        nums[out] = nums[min];
        nums[min] = temp;
    }
}
