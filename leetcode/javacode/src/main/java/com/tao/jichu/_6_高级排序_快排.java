package com.tao.jichu;

public class _6_高级排序_快排 {
    public static int partition(int[] arr,int left,int right) {
        int pivot = right;
        while (left < right) {
            while (arr[left] <= arr[pivot] && left < right) {
                left++;
            }

            while (arr[right] >= arr[pivot] && left < right){
                right--;
            }
            swap(arr,left,right);
        }

        swap(arr,left,pivot);
        return left;
    }

    public static void swap(int[] arr,int left,int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
