package com.tao.comm;

public class _binary_search {
    public static void main(String[] args){

    }

    int binary_search(int[] array, int n, int value){
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(array[mid] > value){
                right = mid - 1;
            }else if(array[mid] < value){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
