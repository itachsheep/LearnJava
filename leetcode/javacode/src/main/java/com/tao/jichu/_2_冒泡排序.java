package com.tao.jichu;

public class _2_冒泡排序 {
    public void bubleSort(int[] arr){
        /**
         * 两两比较，较大放在后面
         * 第一趟 ： i = 0；0 - arr.length -1
         * 第二趟 ： i = 1；0 - arr.length -1 - i
         * 最坏的情况，交换和比较需的次数，n(n-1),运行时间O(n^2)
         */
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1 -i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
