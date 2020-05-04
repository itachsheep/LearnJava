package com.tencent;

import com.Util;

public class _11_归并排序 {
    public static void main(String[] args) {
        int[] arr1 = {9, 23, 4, 32, 3, 1, 54, 7, 76, 34, 78, 89, 6, 45};
        int[] arr2 = {34, 45, 667, 23, 4, 56, 67, 8, 89, 6, 45};
        int[] arr3 = {10, 9, 8, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        mergeSort(arr1,0,arr1.length-1);
        Util.printArrays(arr1);
    }

    /**
     * https://blog.csdn.net/jianyuerensheng/article/details/51262984
     *
     *
     */
    public static void mergeSort(int[] arr,int low,int high){
        int mid = (low + high) / 2;
        if(low < high) {
            mergeSort(arr,low,mid);
            mergeSort(arr,mid + 1,high);
            merge(arr,low,mid,high);
        }
    }

    public static void merge(int[] arr,int low,int mid,int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {
            if(arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        // 把左边剩余的数移入数组
        while (left <= mid){
            temp[index++] = arr[left++];
        }

        // 把右边边剩余的数移入数组
        while (right <= high) {
            temp[index++] = arr[right++];
        }

        // 把新数组中的数覆盖nums数组
        System.out.println(" merge copy temp into arr: " + temp.length
            + ", low: " + low);
        for (int i = 0; i < temp.length; i++) {
            arr[i + low] = temp[i];
        }
    }
}
