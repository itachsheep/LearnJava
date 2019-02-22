package com.tao.jichu;

public class _1_二分查找 {
    public int binarySearch(int[] arr, int key){
        if(arr == null) return -1;
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(key < mid){
                high = mid - 1;
            }else if(key > mid){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
