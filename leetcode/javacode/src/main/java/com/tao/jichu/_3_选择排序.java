package com.tao.jichu;

public class _3_选择排序 {
    /**
     * 第一趟，将最小的放到最前面 比较次数 i= 0， n - 0
     * 第二趟，将第二小的放在第二个位置，i= 1，比较次数 n - 1;
     *
     * 选择排序改进了冒泡排序，将必要的交换次数从O(N^2)减少到O(N)
     * 但是比较次数仍为O(n^2)
     */
    public void selectSort(int[] arr){
        int min;
        for (int i = 0; i < arr.length; i++){
            min = i;
           for(int j = i+1; j < arr.length; j++){
               if(arr[j] < arr[min] ){
                   min = j;
               }
           }
           int temp = arr[i];
           arr[i] = arr[min];
           arr[min] = temp;
        }
    }
}
