package com.tao.jichu;

public class _6_高级排序_快排 {
    public void quickSort(int[] arr,int left,int right){
        if(left > right){
            return;
        }
        int pivot = arr[right];
        int partition = partition(arr,left,right);
        quickSort(arr,left,partition - 1);
        quickSort(arr,partition + 1,right);
    }
    public int partition(int[] arr,int left,int right){
        int pivot = arr[right];
        while (left < right){
            while (arr[left++] < pivot);
            while (arr[--right] > pivot);
            if(left >= right)break;
            swap(arr,left,right);
        }
        swap(arr,left,pivot);
        return left;
    }

    private void swap(int[]arr,int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }
}
