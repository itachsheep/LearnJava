package com.tao.jichu;

public class _4_插入排序 {
    /**
     * 插入排序第一趟最多比较一次，第二趟最多比较二次，
     * 最终最多次数 1+2+3.....+N-1 = N*(N-1)/2
     * 实际平均值 ： N*(N-1)/4
     * 移动复制次数大致等于比较次数，但是移动速度快于交换位置
     * 比冒泡快一倍，略快于选择排序
     */
    public void insertSort(int[] arr){
        for (int out = 1; out < arr.length; out++){
            int in = out;
            int temp = arr[out];
            while (temp > 0 && arr[in - 1] > temp){
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
    }
}
