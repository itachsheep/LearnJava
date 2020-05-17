package com.hr收集腾讯笔试;

public class _12_旋转数组查找 {
    public static void main(String[] args) {
        int[] arr1 = {6,7,9,11,1,3,4};
        int[] arr2 = {8,9, 10, 15, 1, 2,4, 5, 7};
        System.out.println(searchRotateArray(arr1,3));
        System.out.println(searchRotateArray(arr1,7));

        System.out.println(searchRotateArray(arr2,5));
        System.out.println(searchRotateArray(arr2,10));
    }

    /**
     * 二分查找变种
     *
     */
    public static int searchRotateArray(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] == key) {
                return mid;
            }

            if(arr[mid] < arr[right]) {
                if(key > arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(key > arr[right] && key <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
