package com.tencent;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class _38_有序数组中找到最接近目标数的index {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,3,5,7,9,12,15,23,26,34};
        int[] arr3 = {2,45,56,78,89,90,123,334};
        System.out.println("test arr1 -------->");
        System.out.println(findCloset(arr1,0));
        System.out.println(findCloset(arr1,3));
        System.out.println(findCloset(arr1,6));

        System.out.println("test arr2 -------->");
        System.out.println(findCloset(arr2,4));
        System.out.println(findCloset(arr2,8));
        System.out.println(findCloset(arr2,11));

        System.out.println("test arr3 -------->");
        System.out.println(findCloset(arr3,3));
        System.out.println(findCloset(arr3,22));
        System.out.println(findCloset(arr3,87));
        System.out.println(findCloset(arr3,100));

    }

    private static int findCloset(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int middle = 0;
        while (left < right) {
            middle = (right + left) / 2;
            //System.out.println(middle + " ---- > " + arr[middle]);
            if(arr[middle] == target) {
                break;
            }
            if(Math.abs(arr[middle] - target) >
                    Math.abs(arr[middle + 1] - target)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if(Math.abs(arr[middle] - target) >
                Math.abs(arr[middle + 1] - target)) {
            middle = middle + 1;
        }
        return arr[middle];
    }
}
